import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] tile = new String[200000];

        for (int i = 0; i<200000; i++) {
            tile[i] = "Q";
        }

        int now = 100000;


        for (int i = 0; i<N; i++) {
            int x = sc.nextInt();
            String dir = sc.next();

            if (dir.equals("R")) {
                for (int j = now; j<now+x; j++) {
                    tile[j] = "B";
                }
                now += x-1;
            }
            else {
                for (int j = now; j>now-x; j--) {
                    tile[j] = "W";
                }
                now = now-(x-1);
            }
        }

        int black = 0;
        int white = 0;

        for (int i = 0; i<200000; i++) {
            if (tile[i].equals("B")) {
                black++;
            }
            else if (tile[i].equals("W")) {
                white++;
            }
            else {
                continue;
            }
        }

        System.out.print(white + " " + black);

    }
}