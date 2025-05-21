import java.util.Scanner;
public class Main {

    public static int n;
    public static int[][] sum;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        sum = new int[n+1][n+1];
        dp = new int[n+1];

        dp[0] = 0;
        


        sum[0][0] = 1000;
        for (int i = 1; i<=n; i++) {
            sum[0][i] = 1000;
            sum[i][0] = 1000;
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                grid[i][j] = sc.nextInt() + 1000;
        
        sum[1][1] = grid[1][1];

        for (int i = 2; i<=n; i++) {
            sum[1][i] = sum[1][i-1] + grid[1][i] - 1000;
            sum[i][1] = sum[i-1][1] + grid[i][1] - 1000;
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 2; j<=n; j++) {
                sum[i][j] = (sum[i-1][j]-1000) + (sum[i][j-1]-1000) - (sum[i-1][j-1]-1000) + grid[i][j];
            }
        }
        System.out.print(dp());
    }

    public static int dp() {
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                for (int y = 1; y<=n; y++) {
                    int total = (sum[j][y]-1000) - (sum[i-1][y]-1000) - (sum[j][y-1]-1000) + (sum[i-1][y-1]-1000);
                    dp[y] = Math.max(total, dp[y-1] + total);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i= 1; i<=n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}