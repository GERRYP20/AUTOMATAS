import Compiladores.Tokenizer;
import Compiladores.Token;
import java.util.List;

public class test_lexer {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        
        String code = "Main { int x; x = 10; write \"Hello\"; }";
        System.out.println("Input code: " + code);
        System.out.println("\nTokens:");
        
        List<Token> tokens = tokenizer.tokenize(code);
        for (Token token : tokens) {
            System.out.println(token);
        }
        
        System.out.println("\nToken IDs: ");
        int[] ids = tokenizer.getTokenIds();
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}
