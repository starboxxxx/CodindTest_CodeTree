import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int x = 0;
        int y = 0;
        int direction;
        int count = 0;
        boolean answer = false;
        for (int i = 0; i<N; i++) {
            String dir = sc.next();
            int dis = sc.nextInt();

            if (dir.equals("E")) {
                direction = 0;
            }
            else if (dir.equals("N")) {
                direction = 1;
            }
            else if (dir.equals("W")) {
                direction = 2;
            }
            else {
                direction = 3;
            }
            
            for (int j = 1; j<=dis; j++) {
                x += dx[direction];
                y += dy[direction];
                count++;
                if (x == 0 && y == 0) {
                    answer = true;
                    break;
                }
            }

            if (answer == true) {
                System.out.print(count);
                break;
            }
            else if (i == N-1) {
                System.out.print(-1);
            }
        }
    }
}