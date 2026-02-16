package Compiladores;

public class TestSintactico {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Valid program (based on grammar) ===\n");
        // Grammar expects: Main # ... # id Main
        // Where body is: int id; id = 0;
        int[] validTokens = {
            1,  // Main
            2,  // #
            4,  // int
            51, // id
            3,  // ;
            51, // id
            12, // =
            49, // 0
            3,  // ;
            2,  // #
            51, // id
            1   // Main
        };
        
        Sintactico parser1 = new Sintactico();
        boolean success1 = parser1.parse(validTokens);
        System.out.println("Valid program parse successful: " + success1);
        System.out.println("Errors: " + parser1.getErrorCount());
        if (parser1.hasErrors()) {
            System.out.println("Errors found:\n" + parser1.getAllErrors());
        }
        
        System.out.println("\n=== Test 2: Multiple syntax errors ===\n");
        // Missing semicolons and wrong tokens
        int[] errorTokens = {
            1,  // Main (line 1)
            2,  // # (line 1)
            4,  // int (line 2)
            51, // id (line 2)
            // Missing ; here - ERROR 1
            4,  // int (line 3) - Wrong token, should be ; first
            51, // id2 (line 3)
            3,  // ; (line 3)
            51, // id (line 4)
            12, // = (line 4)
            49, // 0 (line 4)
            // Missing ; here - ERROR 2
            2,  // # (line 5)
            51, // id (line 5)
            1   // Main (line 5)
        };
        
        int[] errorLines = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5};
        
        Sintactico parser2 = new Sintactico();
        boolean success2 = parser2.parse(errorTokens, errorLines);
        
        System.out.println("Error program parse successful: " + success2);
        System.out.println("Errors found: " + parser2.getErrorCount());
        System.out.println("\nAll errors:");
        System.out.println(parser2.getAllErrors());
        
        System.out.println("\n=== Test 3: Lexical errors ===\n");
        // Mix of syntax and lexical errors
        int[] lexErrorTokens = {
            1,   // Main
            2,   // #
            4,   // int
            51,  // id
            3,   // ;
            100, // LEXICAL ERROR: invalid character
            51,  // id
            3,   // ;
            2,   // #
            51,  // id
            1    // Main
        };
        
        int[] lexErrorLines = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        
        Sintactico parser3 = new Sintactico();
        boolean success3 = parser3.parse(lexErrorTokens, lexErrorLines);
        
        System.out.println("Lexical error program parse successful: " + success3);
        System.out.println("Errors found: " + parser3.getErrorCount());
        System.out.println("\nAll errors:");
        System.out.println(parser3.getAllErrors());
    }
}
