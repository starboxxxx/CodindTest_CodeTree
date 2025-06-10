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

        int left = 1;
        int right = 1000000000;
        int ans = 0;

        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            int cnt = 1;
            int lastIdx = 0;

            for (int i = 1; i<n; i++) {
                if (arr[i] - arr[lastIdx] >= mid) {
                    cnt++;
                    lastIdx = i;
                }
            }

            if (cnt >= m) {
                left = mid+1;
                ans = Math.max(ans, mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(ans);
        
    }
}