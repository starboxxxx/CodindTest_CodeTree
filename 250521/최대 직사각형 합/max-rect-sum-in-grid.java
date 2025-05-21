import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];

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

        int max = Integer.MIN_VALUE;

        for (int a = 1; a<=n; a++) {
            for (int b = 1; b<=n; b++) {

                for (int i = a; i<=n; i++) {
                    for (int j = b; j<=n; j++) {

                        int x = i-a+1;
                        int y = j-b+1;

                        int total = (sum[i][j]-1000) - (sum[x-1][j]-1000) - (sum[i][y-1]-1000) + (sum[x-1][y-1]-1000);

                        max = Math.max(max, total);
                    }
                }
            }
        }

        System.out.print(max);
    }
}