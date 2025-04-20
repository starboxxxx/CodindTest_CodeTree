import java.util.*;

class City {
    int x;
    int y;
    int height;

    public City(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

public class Main {

    public static int n;
    public static int k;
    public static int u;
    public static int d;
    public static int[][] grid;
    public static int max = Integer.MIN_VALUE;
    public static int[][] selected;
    public static int[][] visited;
    public static Queue<City> q = new LinkedList<>();
    public static ArrayList<City> cities = new ArrayList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        selected = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        backTracking(0);
        
        System.out.print(max);
    }

    public static void backTracking(int count) {

        if (count == k) {
            max = Math.max(max, getMax());
            return;
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (selected[i][j] == 0) {
                    cities.add(new City(i, j, grid[i][j]));
                    selected[i][j] = 1;
                    backTracking(count+1);
                    cities.remove(cities.size()-1);
                    selected[i][j] = 0;
                }
            }
        }
    }

    public static int getMax() {

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                visited[i][j] = 0;
            }
        }
        q.clear();

        int x = 0;
        int y = 0;
        int newX = 0;
        int newY = 0;
        int origin = 0;
        int count = 0;
        for (int i = 0; i<cities.size(); i++) {
            x = cities.get(i).x;
            y = cities.get(i).y;
            
            if (visited[x][y] == 0) {
                visited[x][y] = 1;
                count++;
            }

            origin = cities.get(i).height;

            q.add(new City(x, y, origin));
            
            int c = bfs();
            count += c;
        }

        return count;

        
    }

    public static int bfs() {
        int count = 0;
        while (!q.isEmpty()) {

            City city = q.poll();

            int x = city.x;
            int y = city.y;
            int height = city.height;

            for (int i = 0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY, height)) {
                    visited[newX][newY] = 1;
                    q.add(new City(newX, newY, grid[newX][newY]));
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean canGo(int x, int y, int origin) {
        if (x >=0 && x < n && y >= 0 && y < n
        && visited[x][y] == 0 && Math.abs(origin - grid[x][y]) >= u && Math.abs(origin - grid[x][y]) <= d) {
            return true;
        }
        return false;
    }
}