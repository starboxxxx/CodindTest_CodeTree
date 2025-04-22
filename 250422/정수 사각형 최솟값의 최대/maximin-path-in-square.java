import java.util.Scanner;
public class Main {

    public static int n;
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
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
            matrix[i][0] = Math.min(matrix[i-1][0], matrix[i][0]);
            matrix[0][i] = Math.min(matrix[0][i-1], matrix[0][i]);
        }
    }

    public static int dp() {

        for (int i = 1; i<n; i++) {
            for (int j = 1; j<n; j++) {
                int min = Math.max(matrix[i-1][j], matrix[i][j-1]);
                matrix[i][j] = Math.min(min, matrix[i][j]);
            }
        }

        return matrix[n-1][n-1];
    }
}