package Compiladores;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {
    private Lexico lexico;
    private Automata automata;
    private List<Token> tokens;
    private String textoSalida;
    
    public Tokenizer() {
        this.lexico = new Lexico();
        this.automata = new Automata();
        this.tokens = new ArrayList<>();
        this.textoSalida = "";
    }
    
    public List<Token> tokenize(String input) {
        tokens.clear();
        textoSalida = "";
        
        // Tokenizer including space in delimiters
        StringTokenizer st = new StringTokenizer(input, "\b\r\t\n| #!=<>;&,{}()+-*/%\"' ", true);
        
        String cadena = "";
        String tokenPendiente = "";
        boolean dentroDeCadena = false;
        String acumuladorCadena = "";
        String caracterCierreCadena = "";
        
        while (st.hasMoreTokens() || !tokenPendiente.isEmpty()) {
            // Get next token
            if (!tokenPendiente.isEmpty()) {
                cadena = tokenPendiente;
                tokenPendiente = "";
            } else {
                cadena = st.nextToken();
            }
            
            // String handling logic
            if (!dentroDeCadena) {
                if (cadena.equals("\"") || cadena.equals("'")) {
                    dentroDeCadena = true;
                    caracterCierreCadena = cadena;
                    acumuladorCadena = cadena;
                    continue;
                }
            } else {
                acumuladorCadena += cadena;
                if (cadena.equals(caracterCierreCadena)) {
                    dentroDeCadena = false;
                    processToken(acumuladorCadena, true);
                    acumuladorCadena = "";
                }
                continue;
            }
            
            // Skip whitespace
            if (cadena.trim().isEmpty()) {
                continue;
            }
            
            // Handle compound operators
            if ((cadena.equals("<") || cadena.equals(">") || cadena.equals("=") || 
                 cadena.equals("!") || cadena.equals("&") || cadena.equals("|")) 
                 && st.hasMoreTokens()) {
                
                String siguiente = st.nextToken();
                
                if (!siguiente.trim().isEmpty()) {
                    boolean fusionado = false;
                    
                    if ((cadena.equals("<") && siguiente.equals("=")) || // <=
                        (cadena.equals(">") && siguiente.equals("=")) || // >=
                        (cadena.equals("=") && siguiente.equals("=")) || // ==
                        (cadena.equals("!") && siguiente.equals("=")) || // !=
                        (cadena.equals("<") && siguiente.equals(">")) || // <>
                        (cadena.equals("&") && siguiente.equals("&")) || // &&
                        (cadena.equals("|") && siguiente.equals("|"))) { // ||
                        cadena += siguiente;
                        fusionado = true;
                    }
                    
                    if (!fusionado) {
                        tokenPendiente = siguiente;
                    }
                }
            }
            
            // Process the token
            processToken(cadena, false);
        }
        
        return tokens;
    }
    
    private void processToken(String lexeme, boolean isString) {
        Token token;
        
        if (isString) {
            // Process with Automata for strings
            String etiqueta = automata.etiquetar(lexeme);
            int idToken = extractId(etiqueta);
            String name = extractName(etiqueta);
            token = new Token(idToken, lexeme, name);
        } else {
            // Try Lexico first
            String etiqueta = lexico.etiquetar(lexeme);
            
            if (etiqueta.equals("0")) {
                // Try Automata for identifiers, numbers, etc.
                etiqueta = automata.etiquetar(lexeme);
            }
            
            int idToken;
            String name;
            
            if (etiqueta.startsWith("Error")) {
                idToken = 100;
                name = etiqueta;
            } else {
                idToken = extractId(etiqueta);
                name = extractName(etiqueta);
            }
            
            token = new Token(idToken, lexeme, name);
        }
        
        tokens.add(token);
        textoSalida += token.toString() + "\n";
    }
    
    private int extractId(String etiqueta) {
        try {
            return Integer.parseInt(etiqueta.split(" ")[0]);
        } catch (Exception e) {
            return 0;
        }
    }
    
    private String extractName(String etiqueta) {
        try {
            String[] parts = etiqueta.split(" ");
            if (parts.length > 1) {
                StringBuilder name = new StringBuilder(parts[1]);
                for (int i = 2; i < parts.length; i++) {
                    name.append(" ").append(parts[i]);
                }
                return name.toString();
            }
            return etiqueta;
        } catch (Exception e) {
            return etiqueta;
        }
    }
    
    public String getTextoSalida() {
        return textoSalida;
    }
    
    public int[] getTokenIds() {
        int[] ids = new int[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            ids[i] = tokens.get(i).getId();
        }
        return ids;
    }
    
    public List<Token> getTokens() {
        return tokens;
    }
    
    public boolean hasErrors() {
        for (Token token : tokens) {
            if (token.isError()) {
                return true;
            }
        }
        return false;
    }
    
    public String getFirstError() {
        for (Token token : tokens) {
            if (token.isError()) {
                return token.getName() + ": " + token.getLexeme();
            }
        }
        return null;
    }
}
