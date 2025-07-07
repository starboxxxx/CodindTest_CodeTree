import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        int coin = 0;
        
        for (int i = n-1; i>=0; i--) {
            if (k == 0) {
                break;
            }

            int x = k / coins[i];

            coin += x;

            k -= (coins[i] * x);
        }

        System.out.print(coin);
    }
}