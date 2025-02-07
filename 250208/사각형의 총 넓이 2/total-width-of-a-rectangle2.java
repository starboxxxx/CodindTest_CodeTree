import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] result = new int[200][200];
        
        int N = sc.nextInt();


        for (int i = 0; i<N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            x1 += 100;
            y1 += 100;

            x2= x2 + 100 - 1;
            y2= y2 + 100 - 1;

            for (int z = x1; z<=x2; z++) {
                for (int j = y1; j<=y2; j++) {
                    result[z][j] = 1;
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