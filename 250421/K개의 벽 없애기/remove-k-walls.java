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
    public static int k;
    public static int[][] grid;
    public static int[][] visited1;
    public static int[][] visited2;
    public static int[][] distance;
    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;
    public static int min = Integer.MAX_VALUE;
    public static Queue<Point> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static ArrayList<Point> a = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited1 = new int[n][n];
        visited2 = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        backTracking(0);
        
        int answer = (min == Integer.MAX_VALUE?-1:min);

        System.out.print(answer);
    }

    public static void backTracking(int count) {
        if (count == k && a.size() == k) {
            bfs();
            return;
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == 1 && visited1[i][j] == 0) {
                    a.add(new Point(i,j));
                    visited1[i][j] = 1;
                    backTracking(count+1);
                    visited1[i][j] = 0;
                    a.remove(a.size()-1);
                }
            }
        }
    }

    public static void bfs() {

        for (int i = 0; i<k; i++) {
            grid[a.get(i).x][a.get(i).y] = 0;
        }

        initialize();

        q.add(new Point(r1, c1));
        visited2[r1][c1] = 1;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    visited2[newX][newY] = 1;
                    distance[newX][newY] = distance[x][y] + 1;
                    q.add(new Point(newX, newY));
                }
            }
        }

        if (distance[r2][c2] != 0) {
            min = Math.min(min, distance[r2][c2]);
        }

        for (int i = 0; i<k; i++) {
            grid[a.get(i).x][a.get(i).y] = 1;
        }
    }

    public static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n
        && grid[x][y] == 0 && visited2[x][y] == 0) {
            return true;
        } 
        return false;
    }


    public static void initialize() {
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                visited2[i][j] = 0;
                distance[i][j] = 0;
            }
        }
    }
}