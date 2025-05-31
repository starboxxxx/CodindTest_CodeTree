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

        int index = n-1;
        int min = 1000000000 * 2;
        for (int i = 0; i<n-1; i++) {
            if (index > i) {
                min = Math.min(min, Math.abs(arr[i] + arr[index]));
            }
            while (index-1 > i && Math.abs(arr[i] + arr[index-1]) <= Math.abs(arr[i] + arr[index])) {
                min = Math.min(min, Math.abs(arr[i] + arr[index-1]));
                index--;
            }
        }

        System.out.print(min);
    }
}