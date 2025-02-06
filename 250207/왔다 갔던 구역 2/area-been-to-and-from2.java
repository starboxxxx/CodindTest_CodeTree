import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] num = new int[2001];

        int now = 1000;
        for (int i = 0; i<N; i++) {
            int x = sc.nextInt();
            String dir = sc.next();

            if (dir.equals("R")) {
                for (int j = now; j<now+x; j++) {
                    num[j]++;
                }
                now += x;
            }
            else {
                for (int j = now-x; j<now; j++) {
                    num[j]++;
                }
                now -= x;
            }
        }

        int total = 0;
        for (int i=0; i<2000; i++) {
            if (num[i] >= 2) {
                total++;
            }
        }

        System.out.print(total);    
    }
}