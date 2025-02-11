import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 0;
        int y = 0;

        int dir = 0;

        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};

        String word = sc.next();

        for (int i=0; i<word.length(); i++) {
            char a = word.charAt(i);

            if (a == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (a == 'R') {
                dir = (dir + 1) % 4;
            }
            else {
                x += dirX[dir];
                y += dirY[dir];
            }
        } 

        System.out.print(x + " " + y);
    }
}