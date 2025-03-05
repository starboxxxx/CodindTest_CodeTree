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
        int total = 0;
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    continue;
                }
                for (int z = 0; z<n; z++) {
                    if (z == i || z == j) {
                        continue;
                    }
                    total += arr[z];
                }

                if (Math.abs(total - s) < min) {
                    min = Math.abs(total - s);
                }
                total = 0;
            }
        }

        System.out.print(min);
    }
}