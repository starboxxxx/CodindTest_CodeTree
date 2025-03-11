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
            int index = i;
            int count = 0;
            for (int j = 0; j<m; j++) {
                int num = arr[index];
                index = num;
                count += num;
            }

            
            if (count > max) {
                max = count;
            }
        }

        System.out.print(max);
    }
}