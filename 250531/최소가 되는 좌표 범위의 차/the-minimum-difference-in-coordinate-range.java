import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

class TargetPoint implements Comparable<TargetPoint> {
    int x;
    int y;

    public TargetPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(TargetPoint tp) {
        if (this.y != tp.y) {
            return this.y - tp.y;
        }
        return this.x - tp.x;
    }
}


public class Main {

    public static TreeSet<TargetPoint> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        Point[] point = new Point[n];
        
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            point[i] = new Point(x, y);
        }

        Arrays.sort(point);

        int min = 1000000;
        int j = 0;
        for (int i = 0; i<n; i++) {
            while (j+1<n && getMax() - getMin() < d) {
                set.add(new TargetPoint(point[j+1].x, point[j+1].y));
                j++;
            }

            if (getMax() - getMin() < d) {
                break;
            }

            min = Math.min(min, point[j].x - point[i].x);
            set.remove(new TargetPoint(point[i].x, point[i].y));
        }

        if (min == 1000000) {
            System.out.print(-1);
        }
        else {
            System.out.print(min);
        }
    }

    public static int getMin() {
        if (set.isEmpty()) {
            return 0;
        }

        return set.first().y;
    }

    public static int getMax() {
        if (set.isEmpty()) {
            return 0;
        }

        return set.last().y;
    }
}