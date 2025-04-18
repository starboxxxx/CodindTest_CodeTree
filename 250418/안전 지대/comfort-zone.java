import java.util.Scanner;
public class Main {

    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[][] visited;
    public static int answerA = Integer.MIN_VALUE;
    public static int answerK = 0;
    public static int currentK = 0;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();


        for (int k = 1; k<=100; k++) {
            int a = 0;
            currentK = k;
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    if (grid[i][j] > currentK && visited[i][j] == 0) {
                        a++;
                        DFS(i, j);
                    }
                }
            }
            if (a > answerA) {
                answerA = a;
                answerK = k;
            }
            visited = new int[n][m];
        }

        System.out.print(answerK + " " + answerA);
    }

    public static void DFS(int x, int y) {

        for (int i = 0; i<4; i++) {
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
        && visited[x][y] == 0 && grid[x][y] > currentK) {
            return true;
        }
        return false;
    }
}