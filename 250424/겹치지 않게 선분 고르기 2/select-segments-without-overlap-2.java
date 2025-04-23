import java.util.*;

class Segment implements Comparable<Segment> {
    int x1;
    int x2;

    public Segment() {
    }

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment s) {
        return this.x1 - s.x1;
    }
}


public class Main {

    public static int n;
    public static Segment[] segments;
    public static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new Segment[n];
        dp = new int[n];


        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            segments[i] = new Segment(x1, x2);
        }

        Arrays.sort(segments, 0, n);

        for (int i = 0; i<n; i++) {

            dp[i] = 1;

            for (int j = 0; j<i; j++) {
                int x1I = segments[i].x1;
                int x2J = segments[j].x2;

                if (x2J < x1I) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.print(max);

    }
}