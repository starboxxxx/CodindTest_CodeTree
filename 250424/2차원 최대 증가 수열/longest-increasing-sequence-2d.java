import java.util.Scanner;
public class Main {

    public static int n;
    public static int m;
    public static int[][] grid;
    public static int[][] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        count = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                count[i][j] = Integer.MIN_VALUE;
            }
        }

        count[0][0] = 1;
        
        System.out.print(dp());
    }

    public static int dp() {
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {

                if (count[i][j] == Integer.MIN_VALUE) {
                    continue;
                }

                for (int a = 1; a<n; a++) {

                    if (i + a >= n) {
                        break;
                    }
                    int x = i + a;
                    for (int b = 1; b<m; b++) {
                        if (j + b >= n) {
                            break;
                        }
                        int y = j + b;

                        if (grid[x][y] > grid[i][j]) {
                            count[x][y] = Math.max(count[x][y], count[i][j] + 1);
                        }
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                max = Math.max(max, count[i][j]);
            }
        }
        return max;
    }
}