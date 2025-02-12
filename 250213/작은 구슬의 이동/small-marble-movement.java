import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int T = sc.nextInt();

        int R = sc.nextInt();

        int C = sc.nextInt();

        String D = sc.next();

        int x = R;
        int y = C;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        int dir;
        if (D.equals("U")) {
            dir = 0;
        }
        else if (D.equals("D")) {
            dir = 3;
        }
        else if (D.equals("R")) {
            dir = 1;
        }
        else {
            dir = 2;
        }


        for (int i=0; i<T; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx<=0 || nx>N || ny<=0 || ny>N) {
                dir = 3 - dir;
            }

            else {
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }

        System.out.print(x + " " + y);

    }
}