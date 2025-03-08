import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                if (j == i) {
                    continue;
                }
                int rankA = 0;
                int rankB = 0;
                for (int z = 0; z<k; z++) {
                    for (int h = 0; h<n; h++) {
                        if (arr[z][h] == i) {
                            rankA = h;
                        }

                        if (arr[z][h] == j) {
                            rankB = h;
                        }
                    }

                    if (rankA < rankB) {
                        break;
                    }

                    else if (z == k-1) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}