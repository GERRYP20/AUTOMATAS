package Compiladores;

import java.util.ArrayList;
import java.util.List;

public class TestSintacticoReal {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        
        System.out.println("=== MULTI-ERROR DETECTION TEST ===\n");
        System.out.println("Testing if parser finds multiple errors instead of stopping at first...\n");
        
        System.out.println("=== Test 1: Program with multiple missing semicolons ===\n");
        // Multiple statements missing semicolons - should report multiple errors
        String code1 = "Main { int age string name float balance balance = 100.50 }";
        tokenizer.tokenize(code1);
        int[] tokens1 = tokenizer.getTokenIds();
        
        System.out.println("Input code:");
        System.out.println(code1);
        System.out.println("\nTokens: " + arrayToString(tokens1));
        
        Sintactico parser1 = new Sintactico();
        boolean success1 = parser1.parse(tokens1);
        System.out.println("\nParse successful: " + success1);
        System.out.println("Number of errors: " + parser1.getErrorCount());
        System.out.println("\nErrors found:");
        System.out.println(parser1.getAllErrors());
        
        System.out.println("\n=== Test 2: Multiple syntax errors in sequence ===\n");
        String code2 = "Main { int age; age 18; string name; name \"test\"; write \"hello\" }";
        tokenizer.tokenize(code2);
        int[] tokens2 = tokenizer.getTokenIds();
        
        System.out.println("Input code:");
        System.out.println(code2);
        System.out.println("\nTokens: " + arrayToString(tokens2));
        
        Sintactico parser2 = new Sintactico();
        boolean success2 = parser2.parse(tokens2);
        System.out.println("\nParse successful: " + success2);
        System.out.println("Number of errors: " + parser2.getErrorCount());
        System.out.println("\nErrors found:");
        System.out.println(parser2.getAllErrors());
        
        System.out.println("\n=== Test 3: Valid simple program ===\n");
        String code3 = "Main { int age; age = 18; }";
        tokenizer.tokenize(code3);
        int[] tokens3 = tokenizer.getTokenIds();
        
        System.out.println("Input code:");
        System.out.println(code3);
        System.out.println("\nTokens: " + arrayToString(tokens3));
        
        Sintactico parser3 = new Sintactico();
        boolean success3 = parser3.parse(tokens3);
        System.out.println("\nParse successful: " + success3);
        System.out.println("Number of errors: " + parser3.getErrorCount());
        if (parser3.hasErrors()) {
            System.out.println("\nErrors found:");
            System.out.println(parser3.getAllErrors());
        }
        
        System.out.println("\n=== Summary ===");
        System.out.println("Test 1 errors: " + parser1.getErrorCount());
        System.out.println("Test 2 errors: " + parser2.getErrorCount());
        System.out.println("Test 3 errors: " + parser3.getErrorCount());
        System.out.println("\nIf multi-error detection is working, Test 1 and 2 should show >1 errors.");
    }
    
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
