package Compiladores;

import java.util.ArrayList;
import java.util.List;

public class Sintactico {
    
    private int[] tokens;
    private int currentIndex;
    private int[] stack;
    private List<String> pilaHistory;
    private List<String> entradaHistory;
    private boolean errorDetected;
    private String errorMessage;
    
    public Sintactico() {
        this.pilaHistory = new ArrayList<>();
        this.entradaHistory = new ArrayList<>();
        this.errorDetected = false;
    }
    
    public boolean parse(int[] tokens) {
        // Clean tokens (remove 0s)
        List<Integer> cleanTokens = new ArrayList<>();
        for (int token : tokens) {
            if (token != 0) cleanTokens.add(token);
        }
        
        this.tokens = new int[cleanTokens.size()];
        for (int i = 0; i < cleanTokens.size(); i++) {
            this.tokens[i] = cleanTokens.get(i);
        }
        
        this.currentIndex = 0;
        this.errorDetected = false;
        this.errorMessage = "";
        this.pilaHistory.clear();
        this.entradaHistory.clear();
        
        // Initialize stack with $ and start symbol
        stack = new int[]{0, 150}; // 0 = $, 150 = <Principal>
        
        // Record initial state
        recordState();
        
        // Parsing loop
        while (currentIndex < this.tokens.length || (stack.length > 1 && stack[stack.length - 1] >= 150)) {
            
            // Check for lexical errors
            if (currentIndex < this.tokens.length) {
                if (this.tokens[currentIndex] >= 100) {
                    errorDetected = true;
                    errorMessage = getTokenName(this.tokens[currentIndex]);
                    return false;
                }
                if (this.tokens[currentIndex] >= 54 && this.tokens[currentIndex] < 100) {
                    errorDetected = true;
                    errorMessage = "ID desconocido: " + this.tokens[currentIndex];
                    return false;
                }
            }
            
            int top = stack[stack.length - 1];
            
            // Case 1: Non-terminal on stack top
            if (Grammar.isNonTerminal(top)) {
                int ntIndex = top - 150;
                
                if (currentIndex >= this.tokens.length) {
                    errorDetected = true;
                    errorMessage = "Error sintactico: Fin de archivo inesperado";
                    return false;
                }
                
                int tokenIndex = this.tokens[currentIndex] - 1;
                int rule = Grammar.MATRIX[ntIndex][tokenIndex];
                
                if (rule != -1) {
                    // Apply rule - expand stack
                    expandStack(rule);
                    recordState();
                } else {
                    // Syntax error
                    errorDetected = true;
                    String received = getTokenName(this.tokens[currentIndex]);
                    String expected = Grammar.getNonTerminalName(top);
                    errorMessage = "Error sintactico: Recibido [" + received + "], se esperaba [" + expected + "]";
                    return false;
                }
            }
            // Case 2: Terminal on stack top
            else {
                if (currentIndex >= this.tokens.length) {
                    errorDetected = true;
                    errorMessage = "Error sintactico: Fin de archivo inesperado";
                    return false;
                }
                
                if (this.tokens[currentIndex] == top) {
                    // Match - advance and pop
                    currentIndex++;
                    popStack();
                    recordState();
                } else {
                    // Mismatch error
                    errorDetected = true;
                    String received = getTokenName(this.tokens[currentIndex]);
                    String expected = getTokenName(top);
                    errorMessage = "Error sintactico: Recibido [" + received + "], Se esperaba [" + expected + "]";
                    return false;
                }
            }
        }
        
        // Success if stack is reduced to just $
        return !errorDetected && stack.length > 0 && stack[stack.length - 1] == 0;
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
    
    public String getErrorMessage() {
        return errorMessage;
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
