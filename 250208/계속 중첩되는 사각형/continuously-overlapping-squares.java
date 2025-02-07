import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] result = new int[201][201];

        for (int i = 1; i<=N; i++) {
            int x1 = sc.nextInt()+100;
            int y1 = sc.nextInt()+100;

            int x2 = sc.nextInt()+99;
            int y2 = sc.nextInt()+99;

            int a = 1; //R
            if (i % 2 == 0) {
                a = 2; //B
            }

            for (int j =x1; j<=x2; j++) {
                for (int z=y1; z<=y2; z++) {
                    result[j][z] = a;
                }
            }
        }

        int blue = 0;

        for (int i = 0; i<=200; i++) {
            for (int j = 0; j<=200; j++) {
                if (result[i][j] == 2) {
                    blue++;
                }
            }
        }

        System.out.print(blue);
 
    }
}