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
        
        boolean isTrue = true;
        for (int i = 2; i<=n; i++) {
            for (int j = 0; j<=n-i; j++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int z = j; z<j+i; z++) {
                    max = Math.max(max, arr[z]);
                    min = Math.min(min, arr[z]);
                }

                if (max - min <= k) {
                    break;
                }

                if (j == n-i) {
                    isTrue = false;
                }
            }

            if (isTrue == false) {
                System.out.print(i-1);
                break;
            }
        }
    }
}