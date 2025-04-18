import java.util.*;

public class Main {

    public static int[][] visited;
    public static int n;
    public static int[][] grid;
    public static int count = 1;
    public static ArrayList<Integer> answer;

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static int a=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();


        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    a++;
                    visited[i][j] = 1;
                    DFS(i, j);
                    answer.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(a);
        for (int i = 0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void DFS(int x, int y) {

        for (int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY)) {
                visited[newX][newY] = 1;
                count++;
                DFS(newX, newY);
            }
        }


    }

    public static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n
        && grid[x][y] == 1 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
}