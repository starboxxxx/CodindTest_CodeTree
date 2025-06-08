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

            int target = sc.nextInt();

            int left = 0;
            int right = n-1;
            int lb = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= target) {
                    right = mid-1;
                    lb = Math.min(lb, mid);
                }
                else {
                    left = mid+1;
                }
            }

            left = 0;
            right = n-1;
            int ub = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] > target) {
                    right = mid-1;
                    ub = Math.min(ub, mid);   
                }
                else {
                    left = mid+1;
                }
            }

            System.out.println(ub - lb);
        }
    }
}