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
        
        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i<n-1; i++) {
            int distance=0;
            for (int j = 1; j<=n-1; j++) {
                if (j == i) {
                    continue;
                }
                else if (j == i+1) {
                    int s = Math.abs(x[j-2] - x[j]) + Math.abs(y[j-2] - y[j]);
                    distance += s;
                }
                else {
                    int s = Math.abs(x[j-1] - x[j]) + Math.abs(y[j-1] - y[j]);
                    distance += s;
                }
            }
            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        System.out.print(minDistance);
    }
}