import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                int n = (int) c + 32;
                System.out.print((char) n);
            }
            else if (Character.isLowerCase(c)) {
                int n = (int) c - 32;
                System.out.print((char) n);
            }
        }
    }
}