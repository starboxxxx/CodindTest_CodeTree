import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[] coin;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        coin = new int[n];
        dp = new int[m+1];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        for (int i = 0; i<=m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;

        System.out.print(dp());
    }

    public static int dp() {

        for (int i = 1; i<=m; i++) {
            for (int j = 0; j<n; j++) {

                if (i >= coin[j]) {
                    if (dp[i-coin[j]] == Integer.MIN_VALUE) {
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
                }
            }
        }

        return dp[m];
    }
}