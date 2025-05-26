import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total += arr[i];
        }
        
        long k;
        if (total % 4 != 0) {
            System.out.print(0);
        }
        else {
            k = total / 4;

            long[] L = new long[n];
            long[] R = new long[n];

            L[0] = 0;
            long sum = arr[0];
            long cnt = (sum == k) ? 1: 0;

            for (int i = 1; i<n; i++) {
                sum += arr[i];

                if (sum == 2 * k) {
                    L[i] = cnt;
                }

                if (sum == k) {
                    cnt++;
                }
            }

            R[n-1] = arr[n-1];
            sum = arr[n-1];
            cnt = (sum == k) ? 1: 0;

            for (int i = n-2; i>=0; i--) {
                sum += arr[i];

                if (sum == 2 * k) {
                    R[i] = cnt;
                }

                if (sum == k) {
                    cnt++;
                }
            }

            long ans = 0;

            for (int i = 1; i<n-1; i++) {
                ans += (long) L[i] * R[i+1];
            }
            System.out.print(ans);
            
        }
    }
}