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
            
            sick[i][0] = sc.nextInt();
            sick[i][1] = sc.nextInt();
        }

        for (int i = 0; i<D; i++) {
            for (int j = 0; j<S; j++) {
                int p = sick[j][0];
                int t = sick[j][1];

                if (eat[i][0] == p && eat[i][2] <= t-1) {
                    int m = eat[i][1];

                    for (int z = 0; z<D; z++) {
                        if (eat[z][1] == m) {
                            people[eat[z][0]] = 1;
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