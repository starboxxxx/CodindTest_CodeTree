import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] A = sc.next().toCharArray();
        char[] B = sc.next().toCharArray();

        int a = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        String word1 = new String(A);
        String word2 = new String(B);

        if (word1.equals(word2)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}