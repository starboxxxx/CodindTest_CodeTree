import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        int[] missingNumbers = new int[b];

        for (int i = 1; i<=n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < b; i++) {
            missingNumbers[i] = sc.nextInt();
            arr[missingNumbers[i]] = -1;
        }

        for (int i = 1; i<=n; i++) {
            if (arr[i] == -1) {
                sum[i] = sum[i-1] + 1;
            }
            else {
                sum[i] = sum[i-1];
            }
        }

        int min = Integer.MAX_VALUE;
        
        for (int i = k; i<=n; i++) {
            min = Math.min(min, sum[i] - sum[i-k]);
        }

        System.out.print(min);
    }
}