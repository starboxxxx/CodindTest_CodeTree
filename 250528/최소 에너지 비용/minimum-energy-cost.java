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

        long[] L = new long[n];

        L[1] = cost[0] * dist[0];

        for (int i = 2; i<n; i++) {
            L[i] = L[i-1] + cost[i-1] * dist[i-1];
        }
        
        long min = L[0] + cost[0] * R[0];
        for (int i = 1; i<n; i++) {
            min = Math.min(min, L[i] + cost[i] * R[i]);
        }
        
        System.out.print(min);
    }
}