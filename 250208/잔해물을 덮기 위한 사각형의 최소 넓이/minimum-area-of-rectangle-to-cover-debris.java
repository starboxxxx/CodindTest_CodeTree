import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] result = new int[2001][2001];

        for (int i=0; i<2; i++) {
            int x1 = sc.nextInt()+1000;
            int y1 = sc.nextInt()+1000;

            int x2 = sc.nextInt()+999;
            int y2 = sc.nextInt()+999;

            int a = 1;
            if (i == 1) {
                a=2;
            }
            for (int j = x1; j<=x2; j++) {
                for (int z = y1; z<=y2; z++) {
                    result[j][z] = a;
                }
            }
        }

        int minx = 2001;
        int miny = 2001;
        int maxx = 0;
        int maxy = 0;

        for (int i=0; i<2000; i++) {
            for (int j = 0; j<2000; j++) {
                if (result[i][j] == 1) {
                    if (i < minx) {
                        minx = i;
                    }

                    if (i>maxx) {
                        maxx = i;
                    }

                    if (j < miny) {
                        miny = j;
                    }

                    if (j > maxy) {
                        maxy = j;
                    }
                }
            }
        }

        int total = 0;

        for (int i = minx; i<=maxx; i++) {
            for (int j = miny; j<=maxy; j++) {
                total++;
            }
        }

        System.out.print(total);

    }
}