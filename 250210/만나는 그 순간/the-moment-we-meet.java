import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[1000001];
        int[] B = new int[1000001];

        int now = 1000000;
        int timeA = 1;
        int timeB = 1;
        for (int i = 0; i<N; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j=timeA; j<timeA+t; j++) {

                if (d.equals("R")) {
                        now++;
                }
                else {
                    now--;
                }
                A[j] = now;
            }
            timeA += t;
        }

        now = 1000000;
        for (int i = 0; i<M; i++) {
            String d = sc.next();
            int t = sc.nextInt();

            for (int j=timeB; j<timeB+t; j++) {
                if (j!=0) {
                    if (d.equals("R")) {
                        now++;
                    }
                    else {
                        now--;
                    }
                }
                B[j] = now;
            }
            timeB += t;
        }

        int min = Math.min(timeA, timeB);

        for (int i = 1; i<min; i++) {
            if (A[i] == B[i]) {
                System.out.print(i);
                break;
            }

            if (i == min-1) {
                System.out.print(-1);
            }
        }
    }
}