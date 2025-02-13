import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};

        int x = 0;
        int y = 0;
        int dir = 0;

        int time=0;
        String command = sc.next();

        for (int i = 0; i<command.length(); i++) {
            char c = command.charAt(i);
            if (c=='F') {
                x += dirX[dir];
                y += dirY[dir];
            }

            else if (c=='R') {
                dir = (dir + 1) % 4;
            }
            else {
                dir = (dir + 3) % 4;
            }

            time++;

            if (x == 0 && y == 0) {
                System.out.print(time);
                break;
            }
            else if (i == command.length()-1) {
                System.out.print(-1);
            }
        }
    }
}