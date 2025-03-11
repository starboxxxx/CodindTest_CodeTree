import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        
        for (int i = 1; i<n; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j<=i; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
            }

            if (max - min > k) {
                System.out.print(i);
                break;
            }
        }
    }
}