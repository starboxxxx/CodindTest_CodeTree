import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        
        int[] L = new int[n];

        L[0] = prices[0];
        for (int i = 1; i<n; i++) {
            L[i] = Math.min(L[i-1], prices[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            max = Math.max(max, prices[i] - L[i]);
        }

        System.out.print(max);
        
    }
}