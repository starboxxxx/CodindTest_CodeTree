import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 1;
        int current;
        
        int[] dirX = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dirY = new int[]{0, 1, 0, -1, 1, - 1, 1, -1};

        int dx;
        int dy;

        boolean answer = false;

        for (int i = 0; i<19; i++) {
            for (int j = 0; j<19; j++) {
                if (answer) {
                    break;
                }

                if (arr[i][j] != 0) {
                    current = arr[i][j];
                    int x = i;
                    int y = j;
                    int k = 0;
                    dx = x;
                    dy = y;

                    while (true) {

                        if (count == 5) {
                            System.out.println(current);
                            x += 2 * dirX[k] + 1;
                            y += 2 * dirY[k] + 1;
                            System.out.print(x + " " + y);
                            answer = true;
                            break;
                        }

                        dx += dirX[k];
                        dy += dirY[k];

                        if (dx < 0 || dx >= 19 || dy < 0 || dy >= 19
                        || arr[dx][dy] != current) {
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
    }
}