import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dist = new long[n];
        long[] cost = new long[n];
        for (int i = 0; i < n-1; i++)
            dist[i] = (long) sc.nextInt();
        for (int i = 0; i < n; i++)
            cost[i] = (long) sc.nextInt();
        
        long[] R = new long[n];
        
        for (int i = n-2; i>=0; i--) {
            R[i] = R[i+1] + dist[i];
        }

        long min = cost[0] * R[0];
        long total = 0;
        for (int i = 1; i<n; i++) {
            total += dist[i-1] * cost[i-1];
            min = Math.min(min, total + cost[i] * R[i]);
        }
        
        System.out.print(min);
    }
}