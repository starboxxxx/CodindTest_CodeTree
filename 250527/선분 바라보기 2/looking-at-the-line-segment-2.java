import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    int v;
    int index;

    public Point (int x, int y, int v, int index) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

class SortedPoint implements Comparable<SortedPoint> {
    int index;
    int y;

    public SortedPoint(int index, int y) {
        this.index = index;
        this.y = y;
    }

    @Override
    public int compareTo(SortedPoint sp) {
        if (this.y != sp.y) {
            return this.y - sp.y;
        }
        return this.index - sp.index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            list.add(new Point(x1, y, 1, i));
            list.add(new Point(x2, y, -1, i));
        }

        Collections.sort(list);

        TreeSet<SortedPoint> sort = new TreeSet<>();
        TreeSet<Integer> result = new TreeSet<>();

        int count = 0;
        for (int i = 0; i<2*n; i++) {

            int x = list.get(i).x;
            int y = list.get(i).y;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (v==1) {
                if (sort.isEmpty() || y <= sort.first().y) {
                    result.add(index);
                }
                sort.add(new SortedPoint(index, y));
            }
            else {
                SortedPoint sp = sort.first();

                if (y == sp.y) {
                    sort.remove(sp);
                    if (!sort.isEmpty()) {
                        sp = sort.first();
                        result.add(sp.index);
                    }
                }
                else {
                    sp = new SortedPoint(index, y);
                    sort.remove(sp);
                }
            }
        }

        System.out.print(result.size());
    }
}