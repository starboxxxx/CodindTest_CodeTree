import java.util.*;

public class Main {

    public static int n;
    public static int[][] grid;
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
                int answer = dfs(i, j);
                max = Math.max(max, answer);
            }
        }

        System.out.print(max);

    }


    public static int dfs(int x, int y) {
        if (visited[x][y] != 0) {
            return visited[x][y];
        }

        visited[x][y] = 1;
        for (int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < n
            && grid[newX][newY] > grid[x][y]) {
                visited[x][y] = Math.max(visited[x][y], dfs(newX, newY)+1);
            }
        }
        return visited[x][y];

    }

    public static boolean canGo (int x, int y, int newX, int newY, int num) {
        if (newX >=0 && newX < n && newY >= 0 && newY < n
        && grid[newX][newY] > grid[x][y] && num > visited[newX][newY]) {
            return true;
        }
        return false;
    }
}