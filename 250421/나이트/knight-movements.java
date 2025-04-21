import java.util.*;

class Point {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n;
    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;
    public static int[][] visited;
    public static int[][] distance;
    public static Queue<Point> q = new LinkedList<>();
    public static int[] dx = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    public static int[] dy = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        visited = new int[n][n];
        distance = new int[n][n];
        
        visited[r1][c1] = 1;
        q.add(new Point(r1, c1));
        bfs();

        int result = (visited[r2][c2] == 0 && distance[r2][c2] == 0?-1:distance[r2][c2]);
        System.out.print(result);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i<8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = 1;
                    q.add(new Point(newX, newY));
                    distance[newX][newY] = distance[x][y] + 1;
                }
            }
        }
    }

    public static boolean canGo(int x, int y) {

        if (x >= 0 && x < n && y >= 0 && y < n 
        && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
}