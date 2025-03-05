import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        

        int maxA = 0;
        int maxX = 0;
        int maxY = 0;
        int total = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=n-3; j++) {
                for (int z = j; z<=j+2; z++) {
                    if (arr[i][z] == 1) {
                        total++;
                    }
                }
                if (total > maxA) {
                    maxA = total;
                    maxX = i;
                    maxY = j;
                }
                total = 0;
            }
        }

        int maxB = 0;
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=n-3; j++) {
                for (int z = j; z<=j+2; z++) {
                    if (z >= maxY && z <= maxY + 2 && i == maxX) {
                        total = 0;
                        break;
                    }
                    else if (arr[i][z] == 1) {
                        total++;
                    }
                }
                if (total>maxB) {
                    maxB = total;
                }
                total = 0;
            }
        }

        System.out.print(maxA + maxB);
    }
}