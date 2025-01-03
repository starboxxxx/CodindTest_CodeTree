import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String op = sc.next();

        for (int i = 0; i<op.length(); i++) {
            if (op.charAt(i) == 'L') {
                word = word.substring(1, word.length()) + word.substring(0,1);
            }
            else {
                word = word.substring(word.length()-1, word.length()) + word.substring(0, word.length()-1);
            }
        }

        System.out.print(word);
    }
}