import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            for (int j = 0; j<m; j++) {
                arr[i][j] = word.charAt(j);
            }
        }
        
        int answer = 0;

        int[] dirX = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dirY = new int[]{0, 1, 0, -1, 1, -1, 1, -1};

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j] == 'L') {
                    int x = i;
                    int y = j;

                    int dx = x;
                    int dy = y;
                    int count = 1;

                    int k = 0;
                    while (true) {

                        if (count == 3) {
                            answer++;
                            if (k == 7) {
                                break;
                            }
                            k++;
                            dx = x;
                            dy = y;
                            count = 1;
                        }

                        dx += dirX[k];
                        dy += dirY[k];

                        if (dx < 0 || dx >= n || dy < 0 || dy >= m
                        || (count == 1 && arr[dx][dy]!='E') || (count == 2 && arr[dx][dy]!='E')) {
                        
                            if (k == 7) {
                                break;
                            }

                            k++;
                            dx = x;
                            dy = y;
                            count = 1;
                        }
                        else {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}