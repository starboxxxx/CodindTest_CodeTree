import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] alpha = new char[N][M];
        alpha[0][0] = 'A';

        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        int dir = 0;
        int dx, dy, x=0, y=0;



        for (int i = 1; i<N*M; i++) {
            dx = x + dirX[dir];
            dy = y + dirY[dir];
            if (dx < 0 || dx >=N || dy < 0 || dy >= M || alpha[dx][dy]!='\0') {
                dir = (dir+1)%4;
            }

            x += dirX[dir];
            y += dirY[dir];
            alpha[x][y] = (char)('A'+i);
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                System.out.print(alpha[i][j] + " ");
            }
            System.out.println();
        }
    }
}