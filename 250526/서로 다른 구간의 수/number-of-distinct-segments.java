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
        int[] a = new int[n];
        int[] b = new int[n];

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i<n; i++) {
            list.add(new Point(a[i], 1, i));
            list.add(new Point(b[i], -1, i));
        }

        Collections.sort(list);

        TreeSet<Integer> set = new TreeSet<>();
        int cnt = 0;
        for (int i = 0; i<2 * n; i++) {
            int x = list.get(i).x;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (v == 1) {
                if (set.isEmpty()) {
                    cnt++;
                }

                set.add(index);
            }

            else {
                set.remove(index);
            }
        }
        
        System.out.print(cnt);
        
    }
}