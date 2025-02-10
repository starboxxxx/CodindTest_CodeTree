import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] timeA = new int[1000001];
        int[] timeB = new int[1000001];
        String award = "AB";

        int nowA = 1;
        for (int i = 0; i<N; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();
            for (int j = nowA; j<nowA + t; j++) {
                timeA[j]= timeA[j-1] + v;
            }
            nowA += t;
        }

        int nowB = 1;
        for (int i = 0; i<M; i++) {
            int v = sc.nextInt();
            int t = sc.nextInt();

            for (int j = nowB; j<nowB + t; j++) {
                timeB[j] = timeB[j-1] + v;
            }
            nowB += t;
        }

        int count = 0;

        for (int i = 1; i< nowA; i++) {
            if (timeA[i] == timeB[i]) {
                if (!award.equals("AB")) {
                    count++;
                    award = "AB";
                }
            }
            else if (timeA[i] > timeB[i]) {
                if (!award.equals("A")) {
                    count++;
                    award = "A";
                }
            }
            else if (timeB[i] > timeA[i]) {
                if (!award.equals("B")) {
                    count++;
                    award = "B";
                }
            }
        }

        System.out.print(count);
    }
}