import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] result = new int[N][M];
        int[] dx = new int[]{0, 1, -0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
    

        int dir = 0;
        int x=0;
        int y=0;

        result[x][y] = 1;

        for (int i=2; i<=N*M; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx<0 || nx>=N || ny<0 || ny>=M || result[nx][ny]!=0) {
                dir = (dir+5) % 4;
            }

            x += dx[dir];
            y += dy[dir];

            result[x][y] = i;
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}