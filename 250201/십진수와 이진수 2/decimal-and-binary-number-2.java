import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();

        int[] num = new int[N.length()];

        int n = 0;

        for (int i = 0; i<N.length(); i++) {
            num[i] = N.charAt(i) - '0';
        }

        for (int i = 0; i<num.length; i++) {
            n = n * 2 + num[i];
        }

        n *= 17;

        int[] result = new int[1000000];
        int cnt = 0;

        while (true) {
            if (n < 2) {
                result[cnt] = n % 2;
                break;
            }

            result[cnt++] = n % 2;
            n /= 2;
        }

        for (int i = cnt; i>=0; i--) {
            System.out.print(result[i]);
        }
    }
}