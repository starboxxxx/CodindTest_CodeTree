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
    public static int k;

    public static int[][] grid;
    public static Queue<Point> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int[][] visited;
    public static int[][] result;
    public static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[][] starts = new int[k][2];

        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
        }

        bfs();

        for (int a = 0; a<k; a++) {
            int x = starts[a][0]-1;
            int y = starts[a][1]-1;

            q.add(new Point(x, y));
            visited[x][y] = 1;
            result[x][y] = 1;
            bfs();

            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    visited[i][j] = 0;
                }
            }
        };

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (result[i][j] == 1) {
                    total++;
                }
            }
        }

        System.out.print(total);
    }


    public static void bfs() {

        while (!q.isEmpty()) {
            
            Point point = q.poll();

            int x = point.x;
            int y = point.y;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = 1;
                    result[newX][newY] = 1;
                    q.add(new Point(newX, newY));
                }
            }
        }

    }

    public static boolean canGo(int x, int y) {

        if (x >= 0 && x < n && y >= 0 && y < n
        && visited[x][y] == 0 && grid[x][y] == 0) {
            return true;
        }
        return false;
    }
}