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

        int min = Math.abs(arr[0] + arr[n-1]);

        for (int i = 0; i<n; i++) {

            if (index <= i) {
                break;
            }

            while (index-1 >= 1 && Math.abs(arr[i] + arr[index-1]) < Math.abs(arr[i] + arr[index])) {
                min = Math.min(min, Math.abs(arr[i] + arr[index-1]));
                index--;
            }
        }

        System.out.print(min);
    }
}