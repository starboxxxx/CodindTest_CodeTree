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
        
        long[] minCost = new long[n];
        
        minCost[0] = cost[0];
        for (int i = 1; i<n; i++) {
            minCost[i] = Math.min(minCost[i-1], cost[i]);
        }

        long total = dist[0] * cost[0];
        for (int i = 1; i<n; i++) {
            total += dist[i] * minCost[i];
        }
        
        System.out.print(total);
    }
}