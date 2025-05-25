import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] matches = new char[n+1];
        for (int i = 1; i < n+1; i++) {
            matches[i] = sc.next().charAt(0);
        }

        // h => 주먹
        // s => 가위
        // p => 보

        int[] H = new int[n+1];
        int[] S = new int[n+1];
        int[] P = new int[n+1];

        for (int i = 1; i<=n; i++) {
            H[i] = H[i-1];
            S[i] = S[i-1];
            P[i] = P[i-1];
            if (matches[i] == 'P') {
                S[i]++;
            }

            else if (matches[i] == 'S') {
                H[i]++;
            }

            else {
                P[i]++;
            }
        }

        int max = Integer.MIN_VALUE;

        max = Math.max(max, H[n]);
        max = Math.max(max, S[n]);
        max = Math.max(max, P[n]);

        for (int i = 2; i<=n; i++) {
            int sum1 = H[i-1];

            int sum2 = S[n] - S[i-1];

            int sum3 = P[n] - P[i-1];

            max = Math.max(max, sum1 + sum2);
            max = Math.max(max, sum1 + sum3);

            sum1 = S[i-1];

            sum2 = H[n] - H[i-1];

            sum3 = P[n] - P[i-1];

            max = Math.max(max, sum1 + sum2);
            max = Math.max(max, sum1 + sum3);

            sum1 = P[i-1];

            sum2 = H[n] - H[i-1];

            sum3 = S[n] - S[i-1];

            max = Math.max(max, sum1 + sum2);
            max = Math.max(max, sum1 + sum3);
        }

        System.out.print(max);
        
    }
}