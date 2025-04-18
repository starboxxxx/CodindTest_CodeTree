import java.util.Scanner;
public class Main {

    public static int[][] visited;
    public static int answer = 0;

    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[] dx = new int[]{1, 0};
    public static int[] dy = new int[]{0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        DFS(0, 0);

        System.out.print(answer);
    }


    public static void DFS(int x, int y) {

        if (x == n-1 && y == m-1) {
            answer = 1;
        }

        for (int i = 0; i<2; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY)) {
                visited[newX][newY] = 1;
                DFS(newX, newY);
            }
        }
    }

    public static boolean canGo(int x, int y) {

        if (x >= 0 && x < n && y >= 0 && y < m 
        && grid[x][y] == 1 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
}