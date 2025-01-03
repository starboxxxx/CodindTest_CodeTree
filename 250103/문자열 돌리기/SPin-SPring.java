import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        for (int i = 0; i<=word.length(); i++) {
            int L = word.length();
            if (i == L || i == 0) {
                System.out.println(word);
            }
            else {
                System.out.println(word.substring(L-i, L) + word.substring(0, L-i));
            }
        }
    }
}