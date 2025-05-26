import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int v;
    int index;

    public Point (int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }

}

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            points.add(new Point(a, 1, i));
            points.add(new Point(b ,-1, i));
        }

        Collections.sort(points);

        TreeSet<Integer> set = new TreeSet<>();

        int start = 0;
        int sum = 0;
        for (int i = 0; i<2*n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            if (v == 1) {
                if (set.isEmpty()) {
                    start = x;
                }
                set.add(index);
            }

            else {
                if (set.size() == 1) {
                    sum += x - start;
                }
                set.remove(index);
            }
        }
        
        System.out.print(sum);
    }
}