import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        for (int i = 0; i<word.length(); i++) {
            if (word.charAt(i) == 'e') {
                word = word.substring(0, i) + word.substring(i+1, word.length());
                break;
            }
        }

        System.out.print(word);
    }
}