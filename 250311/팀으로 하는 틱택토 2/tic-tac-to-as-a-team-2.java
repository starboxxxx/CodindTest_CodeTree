import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] number = new int[3][3];


        int minNum = Integer.MAX_VALUE;
        int maxNum = 0;

        for (int i = 0; i<3; i++) {
            String input = sc.next();

            for (int j = 0; j<3; j++) {
                number[i][j] = input.charAt(j) - '0';
                minNum = Math.min(minNum, number[i][j]);
                maxNum = Math.max(maxNum, number[i][j]);
            }
        }

        int[] dirX = new int[]{0, 1, 0 ,-1, 1, -1, 1, -1};
        int[] dirY = new int[]{1, 0, -1, 0, 1, -1, -1, 1};      


        int count = 0;

        for (int i = minNum; i<=maxNum-1; i++) {
            for (int j = i+1; j<=maxNum; j++) {
                
                boolean isTrue = false;
                for (int a = 0; a<3; a++) {
                    for (int b = 0; b<3; b++) {
                        
                        if ((number[a][b] == i || number[a][b] == j)
                        && isTrue == false) {

                            for (int l = 0; l<8; l++) {
                                int x = a;
                                int y = b;
                                for (int p = 0; p<2; p++) {
                                    int dx = x + dirX[l];
                                    int dy = y + dirY[l];

                                    if (dx < 0 || dx >= 3 || dy < 0 || dy >= 3 
                                    || (number[dx][dy] != i && number[dx][dy] != j)) {
                                        break;
                                    }

                                    if (p == 1) {
                                        
                                        if (number[x][y] == number[dx][dy] &&
                                        number[a][b] == number[x][y]) {
                                            break;
                                        }
                                        count++;
                                        isTrue = true;
                                    }

                                    x = dx;
                                    y = dy;
                                }
                                if (isTrue) {
                                    break;
                                }
                            }
                        }

                    }                    
                }
            }
        }

        System.out.print(count);
    }
}