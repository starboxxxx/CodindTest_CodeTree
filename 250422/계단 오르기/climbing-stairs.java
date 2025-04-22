import java.util.Scanner;
public class Main {

    public static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count = new int[n+1];

        for (int i = 0; i<=n; i++) {
            count[i] = -1;
        }

        System.out.print(dp(n));
    }

    public static int dp(int n) {

        if (count[n] != -1) {
            return count[n];
        }

        if (n == 2 || n == 3) {
            count[n] = 1;
        }

        else {
            count[n] = dp(n-2) + dp(n-3);
        }

        return count[n];
    }
}