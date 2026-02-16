package Compiladores;

public class Grammar {
    
    // Grammar rules (matrizGramatica from Principal.java)
    public static final int[][] RULES = {
        {}, // 0 - not used
        {2, 151, 2, 52, 1},        // 1. <Principal>
        {153, 152},                // 2. <Principal1>
        {151},                     // 3. <Principal2>
        {},                        // 4. Lambda
        {157},                     // 5. <principalTipo> -> Comentario
        {158},                     // 6. <principalTipo> -> Sentencia
        {161},                     // 7. <principalTipo> -> Funcion
        {155, 52},                 // 8. <Dec2>
        {},                        // 9. Lambda
        {154, 4},                  // 10. <Dec3>
        {},                        // 11. Lambda
        {5},                       // 12. <tipoDato>
        {8, 53, 7, 6},             // 13. <Comentario>
        {159, 52},                 // 14. <Sentencia> -> ID
        {3, 11, 170, 10, 15},      // 15. <Sentencia> -> Escribir
        {3, 156},                  // 16. <Sentencia> -> Tipo
        {174, 2, 158, 2, 11, 175, 10, 16}, // 17. Si
        {2, 158, 2, 11, 175, 10, 20},      // 18. Mientras
        {160, 12},                 // 19. <Sentencia2> -> =
        {3, 156, 155},             // 20. <Sentencia2> -> Declaracion
        {3, 11, 10, 14},           // 21. <Sentencia3> -> Leer
        {3, 163},                  // 22. <Sentencia3> -> Expresion
        {2, 158, 2, 11, 166, 10, 52, 9},   // 23. Funcion
        {3, 163, 12, 52},          // 24. Asignacion
        {164, 165},                // 25. Expresion
        {164, 165, 13},            // 26. Expresion1
        {},                        // 27. Lambda
        {52},                      // 28. ID
        {50},                      // 29. Num
        {53},                      // 30. Cadena
        {51},                      // 31. Dec
        {11, 163, 10},             // 32. (Exp)
        {167, 156, 52},            // 33. Parametro
        {166, 4},                  // 34. Parametro1
        {},                        // 35. Lambda
        {3, 11, 10, 14, 12, 52},   // 36. Lectura
        {3, 11, 170, 10, 15},      // 37. Escritura
        {172, 171},                // 38. Escritura1
        {52},                      // 39. tipo -> ID
        {53},                      // 40. tipo -> Cadena
        {172, 171, 4},             // 41. Escritura2
        {},                        // 42. Lambda
        {174, 2, 158, 2, 11, 175, 10, 16}, // 43. Sentencia_si
        {173},                     // 44. Sentencia_si2 -> si
        {2, 158, 2, 19},           // 45. Sentencia_si2 -> entonces
        {},                        // 46. Lambda
        {177, 163, 176, 163},      // 47. Condicion
        {17},                      // 48. OpRel
        {175, 178},                // 49. Condicion2
        {},                        // 50. Lambda
        {18},                      // 51. OpLog
        {2, 158, 2, 11, 175, 10, 20} // 52. Sentencia_mientras
    };
    
    // Parsing matrix M
    public static final int[][] MATRIX = new int[30][54];
    
    static {
        // Initialize with -1
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 54; j++) {
                MATRIX[i][j] = -1;
            }
        }
        
        // Fill the matrix based on Principal.java
        MATRIX[0][0] = 1;
        MATRIX[1][4] = 2; MATRIX[1][5] = 2; MATRIX[1][8] = 2; MATRIX[1][14] = 2; 
        MATRIX[1][15] = 2; MATRIX[1][19] = 2; MATRIX[1][51] = 2;
        MATRIX[3][4] = 3; MATRIX[3][5] = 3; MATRIX[3][8] = 3; MATRIX[3][14] = 3; 
        MATRIX[3][15] = 3; MATRIX[3][19] = 3; MATRIX[3][51] = 3; MATRIX[3][1] = 4;
        MATRIX[2][5] = 5;
        MATRIX[2][4] = 6; MATRIX[2][14] = 6; MATRIX[2][15] = 6; MATRIX[2][19] = 6; MATRIX[2][51] = 6;
        MATRIX[2][8] = 7;
        MATRIX[4][51] = 8;
        MATRIX[4][4] = 9;
        MATRIX[5][3] = 10;
        MATRIX[5][4] = 11;
        MATRIX[6][4] = 12;
        MATRIX[7][5] = 13;
        MATRIX[8][51] = 14;
        MATRIX[8][14] = 15;
        MATRIX[8][4] = 16;
        MATRIX[8][15] = 17;
        MATRIX[8][19] = 18;
        MATRIX[9][11] = 19;
        MATRIX[9][3] = 20; MATRIX[9][4] = 20;
        MATRIX[10][13] = 21;
        MATRIX[10][9] = 22; MATRIX[10][49] = 22; MATRIX[10][50] = 22; MATRIX[10][51] = 22; MATRIX[10][52] = 22;
        MATRIX[11][8] = 23;
        MATRIX[12][51] = 24;
        MATRIX[13][9] = 25; MATRIX[13][49] = 25; MATRIX[13][50] = 25; MATRIX[13][51] = 25; MATRIX[13][52] = 25;
        MATRIX[14][12] = 26;
        MATRIX[14][2] = 27; MATRIX[14][10] = 27; MATRIX[14][16] = 27; MATRIX[14][17] = 27;
        MATRIX[15][51] = 28;
        MATRIX[15][49] = 29;
        MATRIX[15][52] = 30;
        MATRIX[15][50] = 31;
        MATRIX[15][9] = 32;
        MATRIX[16][51] = 33;
        MATRIX[17][3] = 34;
        MATRIX[17][10] = 35;
        MATRIX[18][51] = 36;
        MATRIX[19][14] = 37;
        MATRIX[20][51] = 38; MATRIX[20][52] = 38;
        MATRIX[21][51] = 39; MATRIX[21][52] = 40;
        MATRIX[22][3] = 41;
        MATRIX[22][10] = 42;
        MATRIX[23][15] = 43;
        MATRIX[24][15] = 44;
        MATRIX[24][18] = 45;
        MATRIX[24][1] = 46; MATRIX[24][4] = 46; MATRIX[24][5] = 46; MATRIX[24][8] = 46; 
        MATRIX[24][14] = 46; MATRIX[24][19] = 46; MATRIX[24][51] = 46;
        MATRIX[25][9] = 47; MATRIX[25][49] = 47; MATRIX[25][50] = 47; MATRIX[25][51] = 47; MATRIX[25][52] = 47;
        MATRIX[26][16] = 48;
        MATRIX[27][17] = 49;
        MATRIX[27][10] = 50;
        MATRIX[28][17] = 51;
        MATRIX[29][19] = 52;
    }
    
    // Non-terminal names for error reporting
    public static final String[] NON_TERMINALS = {
        "Principal", "Principal1", "principalTipo", "Principal2", "Dec2", "Dec3",
        "tipoDato", "Comentario", "Sentencia", "Sentencia2", "Sentencia3", "Funcion",
        "Asignacion", "Expresion", "Expresion1", "Expresion2", "Parametro", "Parametro1",
        "Lectura", "Escritura", "Escritura1", "tipo", "Escritura2", "Sentencia_si",
        "Sentencia_si2", "Condicion", "opRelacional", "Condicion2", "opLogico", "Sentencia_mientras"
    };
    
    public static String getNonTerminalName(int id) {
        int index = id - 150;
        if (index >= 0 && index < NON_TERMINALS.length) {
            return "<" + NON_TERMINALS[index] + ">";
        }
        return "NonTerminal_" + id;
    }
    
    public static boolean isNonTerminal(int id) {
        return id >= 150;
    }
    
    public static boolean isTerminal(int id) {
        return id < 150;
    }
}
