import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int min = Integer.MAX_VALUE;

        int j = 0;
        int sum = arr[0];

        for (int i = 0; i<n; i++) {
            while (j+1 <n && sum < s) {
                sum += arr[j+1];
                j++;
            }

            if (sum < s) {
                break;
            }

            min = Math.min(min, j-i+1);
            sum -= arr[i];
        }

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else {
            System.out.print(min);
        }
    }
}