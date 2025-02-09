import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] A = new int[1000001];
        int[] B = new int[1000001];

        int N = sc.nextInt();
        int M = sc.nextInt();

        int timeA = 1;

        for (int i = 0; i<N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j = timeA; j<timeA+t; j++) {
                A[j] = A[j-1] + v;
            }
            timeA += t;
        }

        int timeB = 1;

        for (int i = 0; i<M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j = timeB; j<timeB+t; j++) {
                B[j] = B[j-1] + v;
            }
            timeB += t;
        }

        String winner = "F";
        int count = 0;

        for (int i = 0; i<timeA; i++) {
            if (A[i] > B[i]) {
                if (!winner.equals("A")) {
                    winner = "A";
                    count++;
                }
            }
            else if (A[i]<B[i]) {
                if (!winner.equals("B")) {
                    winner = "B";
                    count++;
                }
            }
        }

        System.out.print(count-1);
    }
}