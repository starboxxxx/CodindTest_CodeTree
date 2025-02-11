import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = 0;
        int y = 0;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int nx;
        int ny;

        int N = sc.nextInt();

        for (int i=0; i<N; i++) {
            String dir = sc.next();
            int dist = sc.nextInt();

            int dirNum;
            if (dir.equals("E")) {
                dirNum = 0; 
            }
            else if (dir.equals("N")) {
                dirNum = 1;
            }
            else if (dir.equals("W")) {
                dirNum = 2;
            }
            else {
                dirNum = 3;
            }

            x += dx[dirNum] * dist;
            y += dy[dirNum] * dist;
        }

        System.out.print(x + " " + y);
    }
}