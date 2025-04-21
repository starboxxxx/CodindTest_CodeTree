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
    public static int h;
    public static int m;
    public static int[][] grid;
    public static int[][] visited;
    public static int[][] distance;
    public static Queue<Point> q = new LinkedList<>();
    public static int[][] answer;
    public static ArrayList<Point> a = new ArrayList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        visited = new int[n][n];
        distance = new int[n][n];
        answer = new int[n][n];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 3) {
                    a.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;
                    bfs();
                    int min = Integer.MAX_VALUE;
                    for (int z = 0; z<m; z++) {
                        int d = distance[a.get(z).x][a.get(z).y];
                        if (d != 0 && d < min) {
                            min = d;
                        }
                    }
                    answer[i][j] = (min == Integer.MAX_VALUE?-1:min);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs() {

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                visited[i][j] = 0;
                distance[i][j] = 0;
            }
        }

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited[newX][newY] = 1;
                    distance[newX][newY] = distance[x][y] + 1;
                    q.add(new Point(newX, newY));
                }
            }
        }
    }

    public static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y<n 
        && grid[x][y] != 1 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
}