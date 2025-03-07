import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    continue;
                }

                int dx = Math.abs(x[j] - x[i]) * Math.abs(x[j] - x[i]);
                int dy = Math.abs(y[j] - y[i]) * Math.abs(y[j] - y[i]);

                if (dx + dy < distance) {
                    distance = dx + dy;
                }
            }
        }

        System.out.print(distance);
    }
}