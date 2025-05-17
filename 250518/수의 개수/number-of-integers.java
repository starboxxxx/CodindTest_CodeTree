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
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            
            int minIdx = n;
            int left = 0;
            int right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= x) {
                    right = mid-1;
                    minIdx = Math.min(minIdx, mid);
                }
                else {
                    left = mid+1;
                }
            }

            int lowerBound = minIdx;

            minIdx = n;
            left = 0;
            right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] > x) {
                    right = mid-1;
                    minIdx = Math.min(minIdx, mid);
                }
                else {
                    left = mid+1;
                }
            }

            System.out.println(minIdx - lowerBound);
        }
    }
}