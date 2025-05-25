import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n+1];
        int[] y = new int[n+1];
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int[] sum = new int[n+1];
        sum[1] = 0;
    
        for (int i = 2; i<=n; i++) {
            int total = Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
            sum[i] = sum[i-1] + total;
        }

        for (int i = 2; i<n; i++) {
            int sum1 = sum[i-1];
            int total = sum[n] - sum[i+1];

            int total2 = Math.abs(x[i+1] - x[i-1]) + Math.abs(y[i+1] - y[i-1]);

            int result = total + sum1 + total2;

            min = Math.min(min, result);
        }

        System.out.print(min);
    }
}