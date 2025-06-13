import java.util.Scanner;
public class Main {

    public static int m;
    public static int n;
    public static int[][] board;
    public static int[][] colored;
    public static int[][] visited;
    public static int count=0;
    public static int p;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        colored = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colored[i][j] = sc.nextInt();
                if (colored[i][j] == 1) {
                    count++;
                }
            }
        }
        visited = new int[m][n];

        int left = 0;
        int right = 1000000000;
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean can = true;
            for (int i =0; i<m; i++) {
                if (can == false) {
                    break;
                }
                for (int j = 0; j<n; j++) {
                    if (colored[i][j] == 1) {
                        for (int a = 0; a<m; a++) {
                            for (int b = 0; b<n; b++) {
                                visited[a][b] = 0;
                            }
                        }

                        int startX = i;
                        int startY = j;
                        visited[startX][startY] = 1;
                        p = 1;
                        dfs(startX, startY, mid);

                        if (p != count) {
                            can = false;
                            break;
                        };
                    
                    }
                }
            }

            if (can) {
                right = mid-1;
                answer = Math.min(answer, mid);
            }
            else {
                left = mid+1;
            }
        }

        System.out.print(answer);

    }

    public static void dfs(int x, int y, int mid) {
        
        for (int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < m && newY >= 0 && newY < n
            && visited[newX][newY] == 0 && Math.abs(board[newX][newY] - board[x][y]) <= mid) {
                if (colored[newX][newY] == 1) {
                    p++;
                }
                visited[newX][newY] = 1;
                dfs(newX, newY, mid);
            }
        }
    }
}