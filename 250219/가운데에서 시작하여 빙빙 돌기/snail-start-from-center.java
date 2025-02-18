import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] result = new int[N][N];

        int[] dirX = new int[]{0, -1, 0, 1};
        int[] dirY = new int[]{1, 0, -1, 0};

        int x = (N-1) / 2;
        int y = (N-1) / 2;

        result[x][y] = 1;
        int dx, dy, dir=0;
        int k = 0;
        int current = 1;
        int count = 0;

        for(int i = 2; i<=N * N; i++) {

            if (k == current) {
                dir = (dir + 1) % 4;
                k = 0;
                count++;
            }
            if (count == 2) {
                current++;
                count=0;
            }

            k++;
            x += dirX[dir];
            y += dirY[dir];

            result[x][y] = i;



        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}