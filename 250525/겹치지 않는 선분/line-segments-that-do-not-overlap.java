import java.util.*;

class Point implements Comparable<Point> {
    int x1;
    int x2;

    public Point (int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Point p) {
        return this.x1 - p.x1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] segments = new Point[n];
        
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Point(x1, x2);
        }

        Arrays.sort(segments);

        int[] L = new int[n];
        L[0] = segments[0].x2;

        for (int i = 1; i<n; i++) {
            L[i] = Math.max(L[i-1], segments[i].x2);
        }

        int[] R = new int[n];
        R[n-1] = segments[n-1].x2;
        for (int i = n- 2; i>=0; i--) {
            R[i] = Math.min(R[i+1], segments[i].x2);
        }

        int ans = 0;
        for (int i = 0; i<n; i++) {

            if (i>0 && L[i-1] >= segments[i].x2) {
                continue;
            }

            if (i<n-1 && R[i+1] <= segments[i].x2) {
                continue;
            }

            ans++;
        }

        System.out.print(ans);
        
    }
}