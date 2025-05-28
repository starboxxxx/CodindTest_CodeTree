import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < n-1; i++)
            dist[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            cost[i] = sc.nextInt();
        
        int[] R = new int[n];
        
        for (int i = n-2; i>=0; i--) {
            R[i] = R[i+1] + dist[i];
        }

        long min = (long)Integer.MAX_VALUE;
        long total = 0;
        for (int i = 0; i<n; i++) {
            
            if (i == 0) {
                total = 0;
            }
            else {
                total += (long)dist[i-1] * cost[i-1];
            }
            min = Math.min(min, total + (long)cost[i] * R[i]);
        }
        
        System.out.print(min);
    }
}