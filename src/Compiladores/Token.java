package Compiladores;

public class Token {
    private int id;
    private String lexeme;
    private String name;
    
    public Token(int id, String lexeme, String name) {
        this.id = id;
        this.lexeme = lexeme;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLexeme() {
        return lexeme;
    }
    
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isError() {
        return id >= 100;
    }
    
    public boolean isUnknown() {
        return id >= 54 && id < 100;
    }
    
    @Override
    public String toString() {
        return lexeme + "\t" + id + " " + name;
    }
}
