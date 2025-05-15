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

        if ((this.x + this.y) != (p.x + p.y)) {
            return (this.x + this.y) - (p.x + p.y);
        }
        else if (this.x != p.x) {
            return this.x - p.x;
        }
        return this.y = p.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            pq.add(new Point(x, y));

        }

        while (m-- > 0) {

            Point point = pq.poll();

            int newX = point.x + 2;
            int newY = point.y + 2;

            pq.add(new Point(newX, newY));
        }

        System.out.print(pq.peek().x + " " + pq.peek().y);
    }
}