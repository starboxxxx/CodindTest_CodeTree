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
    public static int[][] visited;
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        boolean isMax = false;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    dfs(i, j, 1);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }

        System.out.print(max);

    }


    public static void dfs(int x, int y, int count) {
        for (int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(x, y, newX, newY, count+1)) {
                visited[newX][newY] = count+1;
                dfs(newX, newY, count+1);
            }
        }
    }

    public static boolean canGo (int x, int y, int newX, int newY, int num) {
        if (newX >=0 && newX < n && newY >= 0 && newY < n
        && grid[newX][newY] > grid[x][y] && num > visited[newX][newY]) {
            return true;
        }
        return false;
    }
}