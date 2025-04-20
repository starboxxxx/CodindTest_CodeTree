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
    public static int count = 0;
    public static int time = 0;

    public static int[][] grid;
    public static Queue<Point> q = new LinkedList<>();
    public static Queue<Point> tmp = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (grid[i][j] == 0) {
                    boolean isTrue = false;
                    for (int z = 0; z<4; z++) {
                        int newI = i + dx[z];
                        int newJ = j + dy[z];

                        if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                            if (grid[newI][newJ] == 0) {
                                isTrue = true;
                                break;
                            }
                        }
                    }
                    if (isTrue) {
                        q.add(new Point(i, j));
                    }
                } 
            }
        }
        bfs();

        while (!tmp.isEmpty()) {
            time++;
            count = tmp.size();
            while (!tmp.isEmpty()) {
                Point point = tmp.poll();
                q.add(new Point(point.x, point.y));
            }
            bfs();
        }

        System.out.print(time + " " + count);
        
    }

    public static void bfs() {
        Point point;
        while (!q.isEmpty()) {
            point = q.poll();
            melt(point.x, point.y);
        }
    }

    public static void melt(int x, int y) {
        
        int newX;
        int newY;
        for (int i = 0; i<4; i++) {
            newX = x + dx[i];
            newY = y + dy[i];

            if (canGo(newX, newY)) {
                grid[newX][newY] = 0;
                tmp.add(new Point(newX, newY));
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (x >=0 && x < n && y >= 0 && y < m
        && grid[x][y] == 1) {
            return true;
        } 
        return false;
    } 



}