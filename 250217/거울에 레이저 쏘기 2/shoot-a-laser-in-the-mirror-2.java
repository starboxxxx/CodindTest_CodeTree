import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] tile = new String[N][N];

        for (int i = 0; i<N; i++) {
            String alpha = sc.next();
            for (int j = 0; j<alpha.length(); j++) {
                tile[i][j] = String.valueOf(alpha.charAt(j));
            }
        }

        int[] dirX = new int[]{-1, 0, 1, 0};
        int[] dirY = new int[]{0, 1, 0, -1};


        int K = sc.nextInt();

        int ax, bx, ay, by, count=0, num;


        if (K>=1 && K <= N) {
            bx = 0;
            by = K-1;
            if (tile[bx][by].equals("/")) {
                num = 3;
            }
            else {
                num = 1;
            }
        }
        else if (K>=N+1 && K<=2*N) {
            bx = K - (N+1);
            by =  N-1;
            if (tile[bx][by].equals("/")) {
                num = 2;
            }
            else {
                num = 0;
            }
        }
        else if (K>=2*N+1 && K<=3*N) {
            bx = N-1;
            by = 3*N-K;
            if (tile[bx][by].equals("/")) {
                num = 1;
            }
            else {
                num = 3;
            }
        }
        else {
            bx = 4*N-K;
            by = 0;
            if (tile[bx][by].equals("/")) {
                num = 0;
            }
            else {
                num = 2;
            }
        }
        count++;
        ax = bx + dirX[num];
        ay = by + dirY[num];

        if (ax < 0 || ax >=N || ay < 0 || ay >= N) {
            System.out.print(count);
        }
        else {
            while (true) {
                String value = tile[ax][ay];
                bx = ax;
                by = ay;
                if (value.equals("/")) {
                    if (num == 0) {
                        num=1;
                    }
                    else if (num == 1) {
                        num = 0;
                    }
                    else if (num == 2) {
                        num = 3;
                    }
                    else {
                        num = 2;
                    }
                }
                else {
                    if (num == 0) {
                        num = 3;
                    }
                    else if (num == 1) {
                        num = 2;
                    }
                    else if (num == 2) {
                        num = 1;
                    }
                    else {
                        num = 0;
                    }
                }
                count++;
                ax = bx + dirX[num];
                ay = by + dirY[num];
                if (ax < 0 || ax >=N || ay <0 || ay >= N) {
                    System.out.print(count);
                    break;
                }

            }
        }

    }
}