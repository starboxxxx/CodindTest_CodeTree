import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] num = new int[N][M];

        int[] dirX = new int[]{1, 0, -1, 0};
        int[] dirY = new int[]{0, 1, 0, -1};

        int dir = 0;

        int x = 0;
        int y = 0;

        int dx = 0;
        int dy = 0;

        for (int i = 1; i<=N*M; i++) {
            num[x][y] = i;
            dx = x + dirX[dir];
            dy = y + dirY[dir];

            if (dx < 0 || dx >= N || dy < 0 || dy >= M || num[dx][dy] != 0) {
                dir = (dir+1) % 4;
            }
            x += dirX[dir];
            y += dirY[dir];
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}