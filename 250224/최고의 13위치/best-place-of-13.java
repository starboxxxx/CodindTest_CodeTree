import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] a = new int[N][N];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int maxCoin = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            for (int j=0; j<=N-3; j++) {
                int current = 0;
                for (int k = j; k<j+3; k++) {
                    current += a[i][k];
                }
                if (current > maxCoin) {
                    maxCoin = current;
                }
            }
        }

        System.out.print(maxCoin);
    }
}