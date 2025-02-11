import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] result = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                result[i][j] = sc.nextInt();
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int count=0;
        int answer=0;
        for (int i =0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                for (int z=0; z<4; z++) {
                    x = i;
                    y = j;
                    x += dx[z];
                    y += dy[z];

                    if (x>=0 && x<N && y>=0 && y<N) {
                        if (result[x][y] == 1) {
                            count++;
                        }
                    }
                }
                if (count>=3) {
                    answer++;
                }
                count = 0;
            }
        }

        System.out.print(answer);
    }
}