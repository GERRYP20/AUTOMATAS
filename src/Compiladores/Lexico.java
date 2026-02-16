package Compiladores;

public class Lexico {
    String lexema;
    String nombre; 
    int num;
    
    static String dic[][] = {
    {"Main", "Main", "1"},
    {"#", "Hash", "2"},
    {";", "Semicolon", "3"},
    {",", "Comma", "4"},
    {"int", "Data Type", "5"},
    {"string", "Data Type", "5"},
    {"float", "Data Type", "5"},
    {"Comment", "Comment", "6"},
    {"{", "Open Brace", "7"},
    {"}", "Close Brace", "8"},
    {"Function", "Function", "9"},
    {"(", "Open Parenthesis", "10"},
    {")", "Close Parenthesis", "11"},
    {"=", "Equals", "12"},
    {"+", "Arithmetic Op", "13"},
    {"-", "Arithmetic Op", "13"},
    {"*", "Arithmetic Op", "13"},
    {"/", "Arithmetic Op", "13"},
    {"%", "Arithmetic Op", "13"},
    {"read", "Read", "14"},
    {"write", "Write", "15"},
    {"if", "If", "16"},
    {"<", "Relational Op", "17"},
    {">", "Relational Op", "17"},
    {"==", "Relational Op", "17"},
    {"<>", "Relational Op", "17"},
    {">=", "Relational Op", "17"},
    {"<=", "Relational Op", "17"},
    {"!=", "Relational Op", "17"},
    {"&&", "Logical Op", "18"},
    {"||", "Logical Op", "18"},
    {"then", "Then", "19"},
    {"while", "While", "20"}
    };
     int etiqueta=0;

    public String etiquetar(String palabra){
        Lexico obLex = new Lexico();
        obLex.lexema = palabra;
        int i = 0;
        boolean ban = false;
        
        while(i < obLex.dic.length){
            if(palabra.equals(dic[i][0])){
                ban = true;
                obLex.nombre = dic[i][1];
                obLex.num = Integer.parseInt(dic[i][2]);
                break;                
            }
            i++;
        }
        if(ban){
            etiqueta=obLex.num;
            return obLex.num+" "+obLex.nombre;
        }
        obLex.nombre = "Pendiente";
        obLex.num = 0;
        etiqueta=0;
        return Integer.toString(obLex.num);
    }
}
