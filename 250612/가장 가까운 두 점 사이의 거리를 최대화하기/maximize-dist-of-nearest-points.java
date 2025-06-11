import java.util.*;

class Point implements Comparable<Point> {
    int start;
    int end;

    public Point (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Point p) {
        if (this.start != p.start) {
            return this.start - p.start;
        }
        return this.end - p.end;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Point[] points = new Point[n];
        
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            points[i] = new Point(x1, x2);
        }

        Arrays.sort(points);

        int left = 1;
        int right = 1000000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean can = true;            
            int current = points[0].start;
            for (int i = 1; i<n; i++) {
                if (current + mid > points[i].end) {
                    can = false;
                    break;
                }
                current = Math.max(points[i].start, current+mid);
            }

            if (can) {
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