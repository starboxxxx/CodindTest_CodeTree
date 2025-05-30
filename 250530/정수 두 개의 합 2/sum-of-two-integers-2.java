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
            
            while (end != 0 && arr[i] + arr[end] > k) {
                end--;
            }

            if (end <= i) {
                break;
            }

            count += end-i;
        }

        System.out.print(count);
    }
}