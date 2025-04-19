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
    public static int m;
    public static int[][] grid;
    public static int[][] visited;
    public static Queue<Point> q = new LinkedList<>();
    public static boolean result = false;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        visited[0][0] = 1;

        q.add(new Point(0, 0));
        
        bfs();
        
        if (result) {
            System.out.print(1);
        }
        else {
            System.out.print(0);   
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point point = q.poll();

            int x = point.x;
            int y = point.y;

            if (x == n-1 && y == m-1) {
                result = true;
                break;
            }

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (check(newX, newY)) {
                    visited[newX][newY] = 1;
                    q.add(new Point(newX, newY));
                }
            }
        }
    }

    public static boolean check(int x, int y) {

        if (x >= 0 && x < n && y >= 0 && y < m
        && visited[x][y] == 0 && grid[x][y] == 1) {
            return true;
        }
        return false;
    }



}