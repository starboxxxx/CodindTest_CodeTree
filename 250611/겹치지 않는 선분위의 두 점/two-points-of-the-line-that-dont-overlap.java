import java.util.*;

class Point implements Comparable<Point> {
    long start;
    long end;

    public Point (long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Point p) { // 반환 타입은 int!
        if (this.start != p.start) {
            return Long.compare(this.start, p.start); // long을 int로 비교
        }
        return Long.compare(this.end, p.end); // long을 int로 비교
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        int m = sc.nextInt();
        Point[] points = new Point[m];
        for (int i = 0; i < m; i++) {

            long start = sc.nextLong();
            long end = sc.nextLong();

            points[i] = new Point(start, end);
        }

        long k = points[0].start;

        Arrays.sort(points);
        

        long left = 0;
        long right = (long) 1e18;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            long current = k;
            long count = 1;
            for (int i = 0; i<m; i++) {
                while (current + mid <= points[i].end) {
                    count++;
                    current += mid;
                }
            }

            if (count >= n) {
                left = mid+1;
                answer = Math.max(answer, mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(answer);
    }
}