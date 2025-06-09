import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 1;
        int right = 1000000;

        int max = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i<n; i++) {
                count += (arr[i] / mid);
            }

            if (count >= m) {
                left = mid+1;
                max = Math.max(max, mid);
            }
            else {
                right = mid-1;
            }
        }

        if (max == Integer.MIN_VALUE) {
            System.out.print(0);
        }
        else {
            System.out.print(max);
        }
    }
}