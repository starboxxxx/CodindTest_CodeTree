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
    public static int m;
    public static int total = 0;

    public static int[][] grid;
    public static int[][] start;
    public static int[][] visited;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int max = Integer.MIN_VALUE;
    public static ArrayList<Point> rocks = new ArrayList<>();
    public static ArrayList<Point> tmp = new ArrayList<>();
    public static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        m = sc.nextInt();
        grid = new int[n][n];
        start = new int[k][2];
        visited = new int[n][n];


        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    rocks.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i<k; i++) {
            start[i][0] = sc.nextInt()-1;
            start[i][1] = sc.nextInt()-1;
        }


        backTracking(0);

        System.out.print(max);
    }

    public static void backTracking(int k) {

        if (k == m && tmp.size() == m) {
            bfs();
            return;
        }

        for (int i = k; i<rocks.size(); i++) {
            tmp.add(rocks.get(i));
            backTracking(k+1);
            tmp.remove(tmp.size()-1);
            backTracking(k+1);
        }
    }

    public static void bfs() {

        for (int i = 0; i<m; i++) {
            grid[tmp.get(i).x][tmp.get(i).y] = 0;
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                visited[i][j] = 0; 
            }
        }

        q.clear();
        int x = 0;
        int y = 0;
        int newX;
        int newY;
        for (int a = 0; a<k; a++) {
            int count = 1;
            x = start[a][0];
            y = start[a][1];

            q.add(new Point(x, y));
            visited[x][y] = 1;

            while(!q.isEmpty()) {

                Point point = q.poll();
                x = point.x;
                y = point.y;

                for (int i = 0; i<4; i++) {
                    newX = x + dx[i];
                    newY = y + dy[i];

                    if (canGo(newX, newY)) {
                        visited[newX][newY] = 1;
                        q.add(new Point(newX, newY));
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }
        for (int i = 0; i<m; i++) {
            grid[tmp.get(i).x][tmp.get(i).y] = 1;
        }
    }

    public static boolean canGo(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n
        && grid[x][y] == 0 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
}