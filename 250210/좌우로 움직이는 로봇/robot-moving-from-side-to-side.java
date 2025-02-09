import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();

        int[] A = new int[1000001];
        int[] B = new int[1000001];

        int timeA=1;
        A[0] = 1000001;
        for (int i = 0; i<N; i++) {
            int t = sc.nextInt();
            String d = sc.next();

            for (int j=timeA; j<timeA+t; j++) {
                if (d.equals("R")) {
                    A[j] = A[j-1] + 1;
                }
                else {
                    A[j] = A[j-1] - 1;
                }
            }
            timeA = timeA + t;
        }

        int timeB=1;
        B[0] = 1000001;
        for (int i = 0; i<M; i++) {
            int t = sc.nextInt();
            String d = sc.next();

            for (int j=timeB; j<timeB+t; j++) {
                if (d.equals("R")) {
                    B[j] = B[j-1] + 1;
                }
                else {
                    B[j] = B[j-1] - 1;
                }
            }
            timeB = timeB + t;
        }

        int max = timeA-1;

        if (timeA > timeB) {
            for (int i = timeB; i<=timeA-1; i++) {
                B[i] = B[timeB-1];
                max = timeA-1;
            }
        }
        else if (timeA < timeB) {
            for (int i = timeA; i<=timeB-1; i++) {
                A[i] = A[timeA-1];
                max = timeB-1;
            }
        }

        int count = 0;
        for (int i = 1; i<=max; i++) {
            if (A[i-1] != B[i-1] && A[i] == B[i]) {
                count++;
            }
        }

        System.out.print(count);
    }
}