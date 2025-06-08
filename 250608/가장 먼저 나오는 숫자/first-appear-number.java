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
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        
        for (int i = 0; i<m; i++) {
            int x = queries[i];

            int left = 0;
            int right = n-1;
            int min = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= x) {
                    right = mid-1;
                    if (arr[mid] == x) {
                        min = Math.min(min, mid);
                    }
                }
                else {
                    left = mid+1;
                }
            }

            if (min == n) {
                System.out.println(-1);
            }
            else {
                System.out.println(min+1);
            }
        }
    }
}