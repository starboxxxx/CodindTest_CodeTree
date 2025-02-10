import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();


        int[] people = new int[N+1];
        int[] move = new int[N+1];

        people[P] = 1;
        int[][] result = new int[251][2];

        for (int i = 0; i<T; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            result[t][0] = x;
            result[t][1] = y;
        }

        int x, y;
        for (int i = 1; i<251; i++) {
            if (result[i][0] != 0 && result[i][1] != 0) {
                x = result[i][0];
                y = result[i][1];

                if (people[x] == 1 && people[y] == 1) {
                    if (move[x] != K) {
                        move[x]++;
                    }
                    if (move[y] != K) {
                        move[y]++;
                    }
                }

                else if (people[x] == 1) {
                    if (move[x] != K) {
                        people[y] = 1;
                        move[x]++;
                    }
                }

                else if (people[y] == 1) {
                    if (move[y] != K) {
                        people[x] = 1;
                        move[y]++;
                    }
                }
            }
        }

        for (int i = 1; i<N+1; i++) {
            System.out.print(people[i]);
        }
    }
}