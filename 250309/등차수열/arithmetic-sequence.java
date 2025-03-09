import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);

        int max = 0;

        for (int i = arr[0] + 1; i<=arr[n-1] - 1; i++) {
            int count = 0;
            for (int j=0; j<n-1; j++) {
                for (int z = j+1; z<n; z++) {
                    if (arr[z] - i == i - arr[j]) {
                        count++;
                    }
                }
            }
            if (count > max) {
                max = count;
            }
        }

        System.out.print(max);
    }
}