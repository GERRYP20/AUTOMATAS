package Compiladores;

public class Lexico {
    String lexema;
    String nombre; 
    int num;
    
    static String dic[][] = {
    {"Principal", "Principal", "1"},
    {"#", "Gato", "2"},
    {";", "Punto y coma", "3"},
    {",", "Coma", "4"},
    {"num", "Tipo de Dato", "5"},
    {"cad", "Tipo de Dato", "5"},
    {"dec", "Tipo de Dato", "5"},
    {"Comentario", "Comentario", "6"},
    {"{", "Llave que abre", "7"},
    {"}", "Llave que cierra", "8"},
    {"Funcion", "Funcion", "9"},
    {"(", "Parentesis que abre", "10"},
    {")", "Parentesis que cierra", "11"},
    {"=", "Igual", "12"},
    {"+", "Op.Aritmetico", "13"},
    {"-", "Op. Aritmetico", "13"},
    {"*", "Op. Aritmetico", "13"},
    {"/", "Op. Aritmetico", "13"},
    {"%", "Op. Aritmetico", "13"},
    {"leer", "Leer", "14"},
    {"escribir", "Escribir", "15"},
    {"si", "Si", "16"},
    {"==", "Op. Relacional", "17"},
    {"<>", "Op. Relacional", "17"},
    {">=", "Op. Relacional", "17"},
    {"<=", "Op. Relacional", "17"},
    {"!=", "Op. Relacional", "17"},
    {"&&", "Op. Logico", "18"},
    {"||", "Op. Logico", "18"},
    {"entonces", "Entonces", "19"},
    {"mientras", "Mientras", "20"}
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
