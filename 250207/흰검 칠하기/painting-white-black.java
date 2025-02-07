import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] black = new int[200000];
        int[] white = new int[200000];

        String[] result = new String[200000];

        for (int i = 0; i<200000; i++) {
            result[i] = "K";
        }

        int now = 100000;

        for (int i = 0; i<n; i++) {
            int x = sc.nextInt();
            String dir = sc.next();

            if (dir.equals("R")) {
                for (int j=now; j<now+x; j++) {
                    result[j] = "B";
                    black[j] += 1;
                }
                now = now + x-1;
            }
            else {
                for(int j = now; j>now-x; j--) {
                    result[j] = "W";
                    white[j] += 1;
                }
                now = now-x+1;
            }
        }

        int b = 0;
        int w = 0;
        int g = 0;

        for (int i=0; i<200000; i++) {
            if (black[i] >=2 && white[i] >= 2) {
                g++;
            }
            else if (result[i].equals("B")) {
                b++;
            }
            else if (result[i].equals("W")){
                w++;
            }
            else {
                continue;
            }
        }

        System.out.print(w + " " + b + " " + g);
    }
}