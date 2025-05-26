import java.util.*;

class Point implements Comparable<Point> {
    int first;
    int second;

    public Point(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Point p) {
        if (this.first != p.first) {
            return this.first-p.first;
        }
        return this.second - p.second;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int current = 0;
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'L') {
                list.add(new Point(current-m, current));
                current -= m;
            }

            else {
                list.add(new Point(current, current+m));
                current += m;
            }
        }

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            int first = list.get(i).first;
            int second = list.get(i).second;

            points.add(new Point(first, 1));
            points.add(new Point(second, -1));
        }

        Collections.sort(points);

        TreeSet<Integer> set = new TreeSet<>();

        int sumval = 0;
        int answer = 0;
        for (int i = 0; i<2*n; i++) {
            
            int x = points.get(i).first;
            int v = points.get(i).second;

            if (sumval >= k) {
                int prev = points.get(i-1).first;
                answer += x - prev;
            }

            sumval += v;
        }

        System.out.print(answer);
        
    }
}