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
    public int compareTo (Point p) {
        return this.x - p.x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Point(a, 1, i));
            list.add(new Point(b, -1, i));
        }

        Collections.sort(list);

        TreeSet<Integer> set = new TreeSet<>();
        int[] sum = new int[n];
        int total = 0;
        int prevX = -1;
        for (int i = 0; i<2*n; i++) {
            int x = list.get(i).x;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (set.size() > 0) {
                total += x - prevX;
            }

            if (set.size() == 1) {
                int target = set.first();
                sum[target] += x - prevX;
            }

            if (v == 1) {
                set.add(index);
            }

            else {
                set.remove(index);
            }

            prevX = x;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<n; i++) {
            min = Math.min(min, sum[i]);
        }

        System.out.print(total - min);
    }
}