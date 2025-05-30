import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
    
        int count = 0;
        int end = n-1;

        for (int i = 0; i<n; i++) {
            int sum = arr[i];
            int j = i;

            while (j+1 <= end && sum + arr[j+1] <= k) {
                count++;
                j++;
            }

            end = j;
        }

        System.out.print(count);
    }
}