import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] result = new int[N][N];

        int[] dirX = new int[]{-1, 0, 1, 0};
        int[] dirY = new int[]{0, 1, 0, -1};

        int count = 0;

        for (int i=0; i<M; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            result[x][y] = 1;

            for (int j = 0; j<4; j++) {
                int dx = x + dirX[j];
                int dy = y + dirY[j];

                if (dx >= 0 && dx<N && dy>=0 && dy<N) {
                    if (result[dx][dy] == 1) {
                        count++;
                    }
                }
            }
            if (count == 3) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
            count = 0;
        }
    }
}