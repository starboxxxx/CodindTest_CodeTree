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

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        Point point = bfs(r, c);

        int answerA = point.x+1;
        int answerB = point.y+1;
        System.out.print(answerA+ " " + answerB);
    }

    public static Point bfs(int r, int c) {

        Point point = new Point(r, c);
        int count = 0;

        while (true) {

            if (canGo(point.x, point.y) == false || count == k) {
                break;
            }

            else {
                point = findMax(point);
                count++;
            }
        }

        return point;
    }

    public static boolean canGo(int x, int y) {
        int newX;
        int newY;

        for (int i = 0; i<4; i++) {
            newX = x + dx[i];
            newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < n
            && grid[newX][newY] < grid[x][y]) {
                return true;
            }
        }

        return false;
    }

    public static Point findMax(Point point) {

        int max = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        int newX;
        int newY;
        Point p;

        Queue<Point> tmp = new LinkedList<>();
        tmp.add(point);

        int[][] visited = new int[n][n];

        while (!tmp.isEmpty()) {
            p = tmp.poll();

            for (int i = 0; i<4; i++) {
                newX = p.x + dx[i];
                newY = p.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n
                && grid[newX][newY] < grid[point.x][point.y]
                && visited[newX][newY] == 0) {
                    tmp.add(new Point(newX, newY));
                    visited[newX][newY] = 1;

                    if (grid[newX][newY] > max) {
                        max = grid[newX][newY];
                        a = newX;
                        b = newY;
                    }
                    else if (grid[newX][newY] == max) {
                        if (newX < a) {
                            a = newX;
                            b = newY;
                        }
                        else if (newX == a && newY < b) {
                            a = newX;
                            b = newY;
                        }
                    }
                    visited[newX][newY] = 1;
                }
            }
        }

        return new Point(a, b);
    }

    public static Point findPosition(int num) {
        Point point = new Point(0, 0);
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (grid[i][j] == num) {
                    return new Point(i, j);
                }
            }
        }

        return point;
    }
}