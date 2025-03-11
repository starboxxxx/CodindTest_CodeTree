import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = arr[0];
        int i = 0;
        while (i!=n-1) {
            int min = Integer.MAX_VALUE;
            int current = 0;
            for (int j = 1; j<=k; j++) {
                if (i+j >= n) {
                    break;
                }
                
                if (arr[i+j] < min) {
                    min = arr[i+j];
                    current = i+j;
                }
            }

            if (min > max) {
                max = min;
            }

            i = current;
        }

        System.out.print(max);
    }
}