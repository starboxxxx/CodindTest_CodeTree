import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] result = new int[200][200];

        for (int i = 0; i<N; i++) {
            int x1 = sc.nextInt()+100;
            int y1 = sc.nextInt()+100;

            int x2 = x1+7;
            int y2 = y1+7;

            for (int j = x1; j<=x2; j++) {
                for (int z = y1; z<= y2; z++) {
                    result[j][z] = 1;
                }
            }
        }

        int total = 0;

        for (int i=0; i<200; i++) {
            for (int j=0; j<200; j++) {
                if (result[i][j] == 1) {
                    total++;
                }
            }
        }

        System.out.print(total);
    }
}