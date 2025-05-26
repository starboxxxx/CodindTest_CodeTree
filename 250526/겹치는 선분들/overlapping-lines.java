import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int m;
    int v;
    int index;

    public Point (int x, int m, int v, int index) {
        this.x = x;
        this.m = m;
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
        int k = sc.nextInt();

        int before = 0;
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'L') {
                list.add(new Point(before-m, m, 1, i));
                list.add(new Point(before, m, -1, i));
            }

            else {
                list.add(new Point(before, m, 1, i));

                before += m;
                list.add(new Point(before, m, -1, i));
            }
        }

        Collections.sort(list);

        TreeSet<Integer> set = new TreeSet<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<2*n; i++) {
            int x = list.get(i).x;
            int m = list.get(i).m;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (v == 1) {
                set.add(index);
            } 
            else {
                if (set.size() >= k) {
                    max = Math.max(max, m);
                }
                set.remove(index);
            }
        }

        System.out.print(max);
        
    }
}