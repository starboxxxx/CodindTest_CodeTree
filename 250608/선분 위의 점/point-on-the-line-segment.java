import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i<m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int left = 0;
            int right = n-1;
            int a = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= start) {
                    right = mid-1;
                    a = Math.min(a, mid);
                }
                else {
                    left = mid+1;
                }
            }

            int b = n;

            left = 0;
            right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] > end) {
                    right = mid-1;
                    b = Math.min(b, mid);
                }
                else {
                    left = mid+1;
                }
            }

            int answer = (b-1) - a + 1;

            System.out.println(answer);
        }
    }
}