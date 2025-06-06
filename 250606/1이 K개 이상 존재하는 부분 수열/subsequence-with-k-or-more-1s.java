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
        
        int j = 0;

        int count = 0;
        int min = Integer.MAX_VALUE;

        if (arr[0] == 1) {
            count++;
        }
        
        for (int i = 0; i<n; i++) {

            while (j+1 < n && count < k) {
                if (arr[j+1] == 1) {
                    count++;
                }
                j++;
            }

            if (count == k) {
                min = Math.min(min, j-i+1);
            }

            if (arr[i] == 1) {
                count--;
            }
        }

        if (min != Integer.MAX_VALUE) {
            System.out.print(min);
        }
        else {
            System.out.print(-1);
        }

    }
}