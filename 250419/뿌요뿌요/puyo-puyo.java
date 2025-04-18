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
    public static int[][] grid;
    public static int[][] destroy;
    public static int[][] visited;
    public static int total = 0;
    public static int max = Integer.MIN_VALUE;
    public static ArrayList<Point> nums = new ArrayList<>();

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        destroy = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (destroy[i][j] == 0) {
                    DFS(i, j);
                    max = Math.max(max, nums.size());
                    if (nums.size() >= 4) {
                        total += 1;
                        for (int z = 0; z<nums.size(); z++) {
                            int x = nums.get(z).x;
                            int y = nums.get(z).y;

                            destroy[x][y] = 1;
                        }
                    }
                    nums.clear();
                    for (int p = 0; p<n; p++) {
                        for (int q = 0; q<n; q++) {
                            visited[p][q] = 0;
                        }
                    }
                }
            }
        }

        System.out.print(total + " " + max);
    }

    public static void DFS(int x, int y) {

        for (int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];


            if (canGo(newX, newY, grid[x][y])) {
                nums.add(new Point(newX, newY));
                visited[newX][newY] = 1;
                DFS(newX, newY);
            }
        }


    }

    public static boolean canGo(int x, int y, int origin) {
        if (x >= 0 && x < n && y >= 0 && y < n &&
        destroy[x][y] == 0 && visited[x][y] == 0 && grid[x][y] == origin) {
            return true;
        }
        return false;
    }

    
}