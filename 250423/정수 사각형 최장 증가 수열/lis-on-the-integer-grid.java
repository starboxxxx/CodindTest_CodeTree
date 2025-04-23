import java.util.*;

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {

    public static int n;
    public static int[][] grid;
    public static Queue<Point> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                q.add(new Point(i, j, 1));
                bfs();
            }
        }

        System.out.print(max);

    }


    public static void bfs() {
        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            int count = point.count;
            boolean isEnd = true;
            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY, grid[x][y])) {
                    isEnd = false;
                    q.add(new Point(newX, newY, count+1));
                }
            }
            if (isEnd) {
                max = Math.max(max, count);
            }
        } 
    }

    public static boolean canGo (int x, int y, int num) {
        if (x >=0 && x < n && y >= 0 && y < n
        && grid[x][y] > num) {
            return true;
        }
        return false;
    }
}