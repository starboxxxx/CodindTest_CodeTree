import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String result = word.substring(0, 1) + word.substring(2, word.length() - 2) + word.substring(word.length()-1, word.length());

        System.out.print(result);
    }
}