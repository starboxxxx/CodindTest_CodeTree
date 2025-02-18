import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int T = sc.nextInt();

        String dirList = sc.next();

        int[][] num = new int[N][N];
        int[] dirX = new int[]{-1, 0, 1, 0};
        int[] dirY = new int[]{0, 1, 0, -1};

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        int x = N / 2;
        int y = N / 2;

        int dx, dy, dir = 0;
        int count=num[x][y];

        for (int i = 0; i<dirList.length(); i++) {
            String a = String.valueOf(dirList.charAt(i));

            if (a.equals("R")) {
                dir = (dir+1)%4;
            }
            else if (a.equals("L")) {
                dir = (dir+3)%4;
            }
            else {
                dx = x + dirX[dir];
                dy = y + dirY[dir];

                if (dx >= 0 && dx < N && dy>=0 && dy < N) {
                    x += dirX[dir];
                    y += dirY[dir];

                    count+=num[x][y];
                }
            }
        }
        System.out.print(count);
    }
}