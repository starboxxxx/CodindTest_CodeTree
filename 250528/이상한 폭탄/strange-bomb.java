import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] bomb = new int[1000001];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i<=n; i++) {
            int m = arr[i];

            if (bomb[m] != 0 && i-bomb[m] <= k) {
                max = Math.max(max, m);
            }

            bomb[m] = i;
        }

        System.out.print(max);
    }
}