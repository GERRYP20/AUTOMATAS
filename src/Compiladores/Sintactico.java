package Compiladores;

import java.util.ArrayList;
import java.util.List;

public class Sintactico {
    
    private int[] tokens;
    private int currentIndex;
    private int[] stack;
    private List<String> pilaHistory;
    private List<String> entradaHistory;
    private List<String> errorMessages;
    private boolean errorDetected;
    private String errorMessage;
    private int errorCount;
    private final int MAX_ERRORS = 20;
    private int lastTokenIndex;
    private int lastStackSize;
    private int tokensSinceLastError;
    private boolean inRecoveryMode;
    private int[] tokenLineNumbers;
    
    // Synchronization tokens for panic mode recovery (structural tokens only)
    private static final int[] SYNC_TOKENS = {3, 8, 1, 4, 5, 14, 15, 16, 19, 9, 20};
    
    public Sintactico() {
        this.pilaHistory = new ArrayList<>();
        this.entradaHistory = new ArrayList<>();
        this.errorMessages = new ArrayList<>();
        this.errorDetected = false;
        this.errorCount = 0;
    }
    
    public boolean parse(int[] tokens) {
        return parse(tokens, null);
    }
    
    public boolean parse(int[] tokens, int[] lineNumbers) {
        // Clean tokens (remove 0s)
        List<Integer> cleanTokens = new ArrayList<>();
        List<Integer> cleanLines = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] != 0) {
                cleanTokens.add(tokens[i]);
                cleanLines.add(lineNumbers != null && i < lineNumbers.length ? lineNumbers[i] : i + 1);
            }
        }
        
        this.tokens = new int[cleanTokens.size()];
        this.tokenLineNumbers = new int[cleanLines.size()];
        for (int i = 0; i < cleanTokens.size(); i++) {
            this.tokens[i] = cleanTokens.get(i);
            this.tokenLineNumbers[i] = cleanLines.get(i);
        }
        
        this.currentIndex = 0;
        this.errorDetected = false;
        this.errorMessage = "";
        this.errorCount = 0;
        this.errorMessages.clear();
        this.pilaHistory.clear();
        this.entradaHistory.clear();
        this.lastTokenIndex = 0;
        this.lastStackSize = 0;
        this.tokensSinceLastError = 0;
        this.inRecoveryMode = false;
        
        // Initialize stack with $ and start symbol
        stack = new int[]{0, 150}; // 0 = $, 150 = <Principal>
        
        // Record initial state
        recordState();
        
        // Parsing loop
        while (currentIndex < this.tokens.length || (stack.length > 1 && stack[stack.length - 1] >= 150)) {
            
            // Track progress since last error
            if (tokensSinceLastError > 0) {
                tokensSinceLastError--;
                if (tokensSinceLastError == 0) {
                    inRecoveryMode = false;
                }
            }
            
            // Check for infinite loop - if no progress was made
            if (currentIndex == lastTokenIndex && stack.length == lastStackSize) {
                // Force recovery if stuck
                if (!tryRecover()) {
                    break;
                }
            }
            lastTokenIndex = currentIndex;
            lastStackSize = stack.length;
            
            // Check for maximum errors reached
            if (errorCount >= MAX_ERRORS) {
                errorMessages.add("Se alcanzo el limite maximo de errores (" + MAX_ERRORS + ").");
                break;
            }
            
            // Check for lexical errors
            if (currentIndex < this.tokens.length) {
                if (this.tokens[currentIndex] >= 100) {
                    String error = formatError("Error lexico", "Token no valido: " + getTokenName(this.tokens[currentIndex]));
                    addError(error);
                    currentIndex++; // Skip the erroneous token
                    continue;
                }
                if (this.tokens[currentIndex] >= 54 && this.tokens[currentIndex] < 100) {
                    String error = formatError("Error lexico", "ID desconocido: " + this.tokens[currentIndex]);
                    addError(error);
                    currentIndex++; // Skip the erroneous token
                    continue;
                }
            }
            
            int top = stack[stack.length - 1];
            
            // Case 1: Non-terminal on stack top
            if (Grammar.isNonTerminal(top)) {
                int ntIndex = top - 150;
                
                if (currentIndex >= this.tokens.length) {
                    if (!inRecoveryMode) {
                        String error = formatError("Error sintactico", "Fin de archivo inesperado, se esperaba [" + Grammar.getNonTerminalName(top) + "]");
                        addError(error);
                    }
                    if (!tryRecover()) break;
                    continue;
                }
                
                int tokenIndex = this.tokens[currentIndex] - 1;
                int rule = Grammar.MATRIX[ntIndex][tokenIndex];
                
                if (rule != -1) {
                    // Apply rule - expand stack
                    expandStack(rule);
                    recordState();
                } else {
                    // Syntax error
                    if (!inRecoveryMode) {
                        String received = getTokenName(this.tokens[currentIndex]);
                        String expected = Grammar.getNonTerminalName(top);
                        String error = formatError("Error sintactico", "Recibido [" + received + "], se esperaba [" + expected + "]");
                        addError(error);
                    }
                    if (!tryRecover()) break;
                }
            }
            // Case 2: Terminal on stack top
            else {
                if (currentIndex >= this.tokens.length) {
                    if (!inRecoveryMode) {
                        String error = formatError("Error sintactico", "Fin de archivo inesperado, se esperaba [" + getTokenName(top) + "]");
                        addError(error);
                    }
                    if (!tryRecover()) break;
                    continue;
                }
                
                if (this.tokens[currentIndex] == top) {
                    // Match - advance and pop
                    currentIndex++;
                    popStack();
                    recordState();
                } else {
                    // Mismatch error
                    if (!inRecoveryMode) {
                        String received = getTokenName(this.tokens[currentIndex]);
                        String expected = getTokenName(top);
                        String error = formatError("Error sintactico", "Recibido [" + received + "], se esperaba [" + expected + "]");
                        addError(error);
                    }
                    if (!tryRecover()) break;
                }
            }
        }
        
        // Success if stack is reduced to just $ and no errors
        return errorCount == 0 && stack.length > 0 && stack[stack.length - 1] == 0;
    }
    
    private void expandStack(int rule) {
        int[] production = Grammar.RULES[rule];
        int[] newStack = new int[(stack.length + production.length) - 1];
        
        // Copy existing stack except top
        System.arraycopy(stack, 0, newStack, 0, stack.length - 1);
        
        // Add production in reverse order (to maintain left-to-right parsing)
        for (int i = 0; i < production.length; i++) {
            newStack[stack.length - 1 + i] = production[i];
        }
        
        stack = newStack;
    }
    
    private void popStack() {
        int[] newStack = new int[stack.length - 1];
        System.arraycopy(stack, 0, newStack, 0, newStack.length);
        stack = newStack;
    }
    
    private void addError(String error) {
        errorMessages.add(error);
        errorDetected = true;
        errorCount++;
        inRecoveryMode = true;
        tokensSinceLastError = 3; // Stay in recovery mode for 3 tokens
    }
    
    private String formatError(String type, String message) {
        int line = (currentIndex < tokenLineNumbers.length) ? tokenLineNumbers[currentIndex] : currentIndex + 1;
        String tokenName = (currentIndex < tokens.length) ? getTokenName(tokens[currentIndex]) : "EOF";
        return type + " en linea " + line + ": " + message;
    }
    
    private boolean tryRecover() {
        // Panic mode recovery: skip tokens until synchronization token is found
        int initialIndex = currentIndex;
        inRecoveryMode = true;
        
        // Skip current erroneous token
        if (currentIndex < tokens.length) {
            currentIndex++;
        }
        
        // Look for synchronization token
        while (currentIndex < tokens.length) {
            int currentToken = tokens[currentIndex];
            
            // Check if current token is a synchronization token
            if (isSyncToken(currentToken)) {
                // Try to synchronize the stack - this will pop elements until valid
                if (synchronizeStack(currentToken)) {
                    tokensSinceLastError = 3; // Reset recovery counter
                    // Don't advance currentIndex - let the main loop process the sync token
                    return true;
                }
            }
            currentIndex++;
        }
        
        // If we reached end of file, try to clear stack
        if (currentIndex >= tokens.length) {
            // Pop all non-terminals and unmatched terminals
            while (stack.length > 1) {
                popStack();
            }
            return true;
        }
        
        return currentIndex > initialIndex;
    }
    
    private boolean isSyncToken(int token) {
        for (int syncToken : SYNC_TOKENS) {
            if (token == syncToken) return true;
        }
        return false;
    }
    
    private boolean synchronizeStack(int syncToken) {
        // Try to pop stack until we find a state that can handle the sync token
        // Actually modify the stack, not just check
        boolean modified = false;
        
        while (stack.length > 1) {
            int top = stack[stack.length - 1];
            
            if (Grammar.isNonTerminal(top)) {
                int ntIndex = top - 150;
                int tokenIndex = syncToken - 1;
                
                if (tokenIndex >= 0 && tokenIndex < Grammar.MATRIX[0].length) {
                    int rule = Grammar.MATRIX[ntIndex][tokenIndex];
                    if (rule != -1) {
                        // Found a matching rule - expand it
                        expandStack(rule);
                        modified = true;
                        return true;
                    }
                }
                // Cannot derive sync token, pop and try next
                popStack();
                modified = true;
            } else {
                // Terminal on stack - check if it matches sync token
                if (top == syncToken) {
                    // Stack is ready for this sync token
                    return true;
                }
                // Pop mismatched terminal
                popStack();
                modified = true;
            }
        }
        
        // If stack is empty except $, add Principal back
        if (stack.length == 1 && stack[0] == 0) {
            int[] newStack = new int[]{0, 150};
            stack = newStack;
            return true;
        }
        
        return modified;
    }
    
    private void recordState() {
        // Record stack state
        StringBuilder pila = new StringBuilder();
        for (int j = 0; j < stack.length; j++) {
            pila.append(stack[j]).append(" ");
        }
        pilaHistory.add(pila.toString());
        
        // Record remaining input
        StringBuilder entrada = new StringBuilder();
        for (int k = currentIndex; k < tokens.length; k++) {
            entrada.append(tokens[k]).append(" ");
        }
        entrada.append("$");
        entradaHistory.add(entrada.toString());
    }
    
    public String getPilaHistory() {
        StringBuilder sb = new StringBuilder("$ 150");
        for (String line : pilaHistory) {
            sb.append("\n").append(line);
        }
        return sb.toString();
    }
    
    public String getEntradaHistory() {
        StringBuilder sb = new StringBuilder();
        // Initial state
        for (int token : tokens) {
            sb.append(token).append(" ");
        }
        sb.append("$");
        
        for (String line : entradaHistory) {
            sb.append("\n").append(line);
        }
        return sb.toString();
    }
    
    public String getFullPilaHistory() {
        return "$ 150\n" + String.join("\n", pilaHistory);
    }
    
    public boolean hasError() {
        return errorDetected;
    }
    
    public boolean hasErrors() {
        return errorCount > 0;
    }
    
    public int getErrorCount() {
        return errorCount;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String getAllErrors() {
        if (errorMessages.isEmpty()) {
            return "No se encontraron errores.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Total de errores encontrados: ").append(errorCount).append("\n\n");
        for (int i = 0; i < errorMessages.size(); i++) {
            sb.append("Error ").append(i + 1).append(": ").append(errorMessages.get(i)).append("\n");
        }
        return sb.toString();
    }
    
    public static String getTokenName(int id) {
        // Search in Lexico dictionary (tokens 1-20)
        for (int i = 0; i < Lexico.dic.length; i++) {
            try {
                int idDic = Integer.parseInt(Lexico.dic[i][2]);
                if (idDic == id) {
                    return Lexico.dic[i][1];
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        
        // Error codes (100-109)
        switch (id) {
            case 100: return "Error 100: CARÁCTER NO VALIDO";
            case 101: return "Error 101: CADENA NO VALIDA";
            case 102: return "Error 102: CADENA NO VALIDA";
            case 103: return "Error 103: CADENA NO VALIDA";
            case 104: return "Error 104: CADENA NO VALIDA";
            case 105: return "Error 105: CADENA NO VALIDA";
            case 106: return "Error 106: NUMERO NO VALIDO";
            case 107: return "Error 107: DECIMAL NO VALIDO";
            case 108: return "Error 108: DECIMAL NO VALIDO";
            case 109: return "Error 109: IDENTIF. NO VALIDO";
        }
        
        // Automata tokens (50-53)
        switch (id) {
            case 50: return "Numero Entero";
            case 51: return "Numero Decimal";
            case 52: return "Identificador";
            case 53: return "Cadena";
            case 0: return "Fin de Archivo ($)";
        }
        
        // Non-terminals (150-179)
        if (id >= 150) {
            return Grammar.getNonTerminalName(id);
        }
        
        return "Token Desconocido (" + id + ")";
    }
}
