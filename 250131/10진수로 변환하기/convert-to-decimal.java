import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        int[] num = new int[n.length()];

        int result = 0;

        for (int i = 0; i<n.length(); i++) {
            int k = n.charAt(i);
            num[i] = k-'0';
        }

        for (int i = 0; i<n.length(); i++) {
            result = result * 2 + num[i];
        }

        System.out.print(result);
    }
}