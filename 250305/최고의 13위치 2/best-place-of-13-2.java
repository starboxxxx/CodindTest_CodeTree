import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        

        int max = 0;
        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=n-3; j++) {
                for (int z = j; z<=j+2; z++) {
                    if (arr[i][z] == 1) {
                        totalA++;
                    }
                }
                for (int a = 0; a<n; a++) {
                    for (int b = 0; b<=n-3; b++) {
                        for (int c = b; c<=b+2; c++) {
                            if (c >= j && c <= j + 2 && a == i) {
                                totalB = 0;
                                break;
                            }
                            else if (arr[a][c] == 1) {
                                totalB++;
                            }
                        }
                        if (totalA + totalB > max) {
                            max = totalA + totalB;
                        }
                        totalB = 0;
                    }
                }
                totalA = 0;
            }
        }

        System.out.print(max);
    }
}