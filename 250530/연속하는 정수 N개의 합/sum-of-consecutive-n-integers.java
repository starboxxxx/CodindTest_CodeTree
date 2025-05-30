import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int count = 0;
        int sum = arr[0];
        int j = 0;

        for (int i = 0; i<n; i++) {

            while (j+1<n && sum + arr[j+1] <= m) {
                sum += arr[j+1];
                j++;
            }

            if (sum == m) {
                count++;
            }

            sum -= arr[i];
        }

        System.out.print(count);

    }
}