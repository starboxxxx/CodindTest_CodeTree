import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        
        for (int i = 1; i<=n; i++) {
            int a = arr[i];
            int b = arr[a];
            int c = arr[b];

            
            if (a + b + c > max) {
                max = a + b + c;
            }
        }

        System.out.print(max);
    }
}