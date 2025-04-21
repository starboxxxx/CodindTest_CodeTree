import java.util.*;

class Fruit {
    int x;
    int y;

    public Fruit(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n;
    public static int k;
    public static int[][] grid;
    public static int[][] visited;
    public static int[][] time;
    public static Queue<Fruit> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        time = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    visited[i][j] = 1;
                    q.add(new Fruit(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(-1 + " ");
                }
                else if (visited[i][j] == 0){
                    System.out.print(-2 + " ");
                }
                else {
                    System.out.print(time[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Fruit fruit = q.poll();

            int x = fruit.x;
            int y = fruit.y;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = 1;
                    time[newX][newY] = time[x][y] + 1;
                    q.add(new Fruit(newX, newY));
                }
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n
        && visited[x][y] == 0 && grid[x][y] == 1) {
            return true;
        }
        return false;
    }
}