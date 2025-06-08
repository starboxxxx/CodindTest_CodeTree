import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        for (int i = 0; i<m; i++) {
            int target = sc.nextInt();
            int idx = -1;
            int left = 0;
            int right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == target) {
                    idx = mid+1;
                    break;
                }
                else if (arr[mid] > target) {
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }

            System.out.println(idx);
        }


    }
}