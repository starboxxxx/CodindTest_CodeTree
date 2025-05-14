import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }

        return this.x - p.x;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Point> set = new TreeSet<>();

        for (int i = 0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            set.add(new Point(x, y));
        }

        for (int i = 0; i<m; i++) {
            int k = sc.nextInt();
            Point p = new Point(k, 0);

            if (set.ceiling(p) == null) {
                System.out.println(-1 + " " + -1);
            }
            else {
                System.out.println(set.ceiling(p).x + " " + set.ceiling(p).y);
                set.remove(set.ceiling(p));
            }
        }
    }
}