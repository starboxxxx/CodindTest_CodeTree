import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        int[][] eat = new int[D][3];

        int[] people = new int[N+1];


        for (int i = 0; i < D; i++) {
            eat[i][0] = sc.nextInt();
            eat[i][1] = sc.nextInt();
            eat[i][2] = sc.nextInt();
        }

        int[][] sick = new int[S][2];

        for (int i = 0; i < S; i++) {
            
            int p = sc.nextInt();
            int t = sc.nextInt();

            sick[i][0] = p;
            sick[i][1] = t;
        }

        int[] cheese = new int[M+1];

        for (int i = 1; i<=M; i++) {
            boolean isBad = true;
            for (int j = 0; j<S; j++) {
                int p = sick[j][0];
                int t = sick[j][1];

                for (int z = 0; z<D; z++) {
                    if (eat[z][1] == i
                    && eat[z][0] == p && eat[z][2] <= t-1) {
                        break;
                    }
                    else if (z == D-1) {
                        isBad = false;
                    }
                }

                if (isBad == false) {
                    break;
                }
                
                if (j == S-1) {
                    for (int h = 0; h<D; h++) {
                        if (eat[h][1] == i) {
                            people[eat[h][0]] = 1;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i<N+1; i++) {
            if (people[i] == 1) {
                count++;
            }
        }

        System.out.print(count);
    }
}