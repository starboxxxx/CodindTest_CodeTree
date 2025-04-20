import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    public static int n;
    public static int m;

    public static int[][] a;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int[][] visited;
    public static int[][] distance;
    public static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        visited = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        q.add(new Point(0, 0));
        visited[0][0] = 1;
        bfs();

        if (distance[n-1][m-1] == 0) {
            System.out.print(-1);
        }
        else {
            System.out.print(distance[n-1][m-1]);
        }
    }   

    public static void bfs() {

        while (!q.isEmpty()) {
            Point point = q.poll();

            int x = point.x;
            int y = point.y;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m
                && visited[newX][newY] == 0
                && a[newX][newY] == 1) {
                    visited[newX][newY] = 1;
                    distance[newX][newY] = distance[x][y] + 1;
                    q.add(new Point(newX, newY));
                }
            }
        }
    }
}