import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.next();
        int q = sc.nextInt();

        for (int i = 1; i<=q; i++) {
            int n = sc.nextInt();
            if (n == 1) {
                word = word.substring(1, word.length()) + word.substring(0, 1);
                System.out.println(word);
            }
            else if (n == 2) {
                word = word.substring(word.length()-1, word.length()) + word.substring(0, word.length()-1);
                System.out.println(word);
            }
            else {
                StringBuffer sb = new StringBuffer(word);
                word = sb.reverse().toString();
                System.out.println(word);
            }
        }
    }
}