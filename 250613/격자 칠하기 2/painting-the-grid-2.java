import java.util.*;

class Point {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();
        

        int left = 1;
        int right = 1000000;
        int answer = 1000001;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        Queue<Point> q = new LinkedList<>();
        int result = Math.round((float)(n*n) / 2);
        while (left <= right) {

            int mid = (left + right) / 2;

            boolean can = false;
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    q.add(new Point(i, j));
                    int count = 1;
                    int[][] visited = new int[n][n];
                    visited[i][j] = 1;
                    while (!q.isEmpty()) {
                        Point p = q.poll();

                        int currentX = p.x;
                        int currentY = p.y;

                        for (int a = 0; a<4; a++) {
                            int newX = currentX + dx[a];
                            int newY = currentY + dy[a];

                            if (newX >= 0 && newX < n && newY >= 0 && newY < n
                            && visited[newX][newY] == 0) {
                                if (Math.abs(board[newX][newY] - board[currentX][currentY]) <= mid) {
                                    q.add(new Point(newX, newY));
                                    count++;
                                    visited[newX][newY] = 1;
                                }
                            }
                        }
                    }
                    if (count >= result) {
                        can = true;
                        break;
                    }
                }
            }

            if (can) {
                answer = Math.min(answer, mid);
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }

        System.out.print(answer);
    }
}