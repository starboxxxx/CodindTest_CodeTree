import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String n = sc.next();

        int num = 0;

        for (int i = 0; i<n.length(); i++) {
            num = num * a + n.charAt(i) - '0';
        }

        int[] result = new int[10000000];

        int i = 0;
        while (true) {
            if (num < b) {
                result[i] = num;
                break;
            }

            result[i++] = num % b;
            num /= b;
        }

        for (int k = i; k>=0; k--) {
            System.out.print(result[k]);
        }
    }
}