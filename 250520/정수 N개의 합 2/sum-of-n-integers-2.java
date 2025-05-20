import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
            if (i == 0) {
                sum[i] = arr[i];
            }
            else {
                sum[i] = sum[i-1] + arr[i];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = k-1; i<n; i++) {
            if (i == k-1) {
                max = Math.max(max, sum[i]);
            }
            else {
                max = Math.max(max, sum[i]-sum[i-k]);
            }
        }

        System.out.print(max);
    }
}