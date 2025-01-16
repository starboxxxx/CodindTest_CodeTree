import java.util.*;

class Point {
    int x;
    int y;
    int num;
    int distance;

    public Point(int x, int y, int num, int distance) {
        this.x = x;
        this.y = y;
        this.num = num;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        Point[] points = new Point[N];

        for (int i = 0; i<N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int distanceX = 0-x;
            int distanceY = 0-y;

            if (distanceX < 0) {
                distanceX = 0 - distanceX;
            }

            if (distanceY < 0) {
                distanceY = 0 - distanceY;
            }

            int distance = distanceX + distanceY;

            Point point = new Point(x, y, i+1, distance);
            points[i] = point;
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.distance == b.distance) {
                    return a.num - b.num;
                }
                return a.distance - b.distance;
            }
        });

        for (int i=0; i<N; i++) {
            System.out.println(points[i].num);
        }
    }
}