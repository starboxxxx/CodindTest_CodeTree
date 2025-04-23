import java.util.Scanner;
public class Main {
    public static int n;
    public static int[][] matrix;
    public static int[] dx = new int[]{1, 0};
    public static int[] dy = new int[]{0, 1};
    public static int[][] max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        max = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        initialize();


        System.out.print(dp());

    }

    public static void initialize() {

        for (int i = 1; i<n; i++) {
            matrix[i][0] = Math.max(matrix[i][0], matrix[i-1][0]);
            matrix[0][i] = Math.max(matrix[0][i], matrix[0][i-1]);
        }
    }

    public static int dp() {
        for (int i = 1; i<n; i++) {
            for (int j = 1; j<n; j++) {
                int m = Math.min(matrix[i-1][j], matrix[i][j-1]);
                matrix[i][j] = Math.max(matrix[i][j], m);
            }
        }

        return matrix[n-1][n-1];
    }
}