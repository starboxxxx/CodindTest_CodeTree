import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sum[1][1] = arr[1][1];

        for (int i = 2; i<=n; i++) {
            sum[i][1] = sum[i-1][1] + arr[i][1];
            sum[1][i] = sum[1][i-1] + arr[1][i];
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 2; j<=n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = k; i<=n; i++) {
            for (int j = k; j<=n; j++) {
                int newI = i - k+1;
                int newJ = j - k+1;

                int p = sum[i][j] - sum[newI-1][j] - sum[i][newJ-1] + sum[newI-1][newJ-1];

                max = Math.max(max, p);
            }
        }
        
        System.out.print(max);

    }
}