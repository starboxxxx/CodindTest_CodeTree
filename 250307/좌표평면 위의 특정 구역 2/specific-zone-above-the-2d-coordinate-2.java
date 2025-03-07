import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i<N; i++) {
            int maxX = 0;
            int minX = Integer.MAX_VALUE;

            int maxY = 0;
            int minY = Integer.MAX_VALUE;
            for (int j = 0; j<N; j++) {
                if (j == i) {
                    continue;
                }

                if (x[j] > maxX) {
                    maxX = x[j];
                }

                if (x[j] < minX) {
                    minX = x[j];
                }

                if (y[j] > maxY) {
                    maxY = y[j];
                }

                if (y[j] < minY) {
                    minY = y[j];
                }
            }
            if ((maxX - minX) * (maxY - minY) < answer) {
                    answer = (maxX - minX) * (maxY - minY);
            }
        }

        System.out.print(answer);
    }
}