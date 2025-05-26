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

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            list.add(new Point(x1, 1, i));
            list.add(new Point(x2, -1, i));
        }

        Collections.sort(list);

        TreeSet<Integer> set = new TreeSet<>();

        int count = 0;
        int max = 1;
        for (int i = 0; i< 2*n; i++) {
            int x = list.get(i).x;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (index == 1) {
                if (set.isEmpty()) {
                    count = 0;
                }
                set.add(index);
                count++;
            }

            else {
                if (set.size() == 1) {
                    max = Math.max(max, count);
                }

                set.remove(index);
            }
        }
        
        System.out.print(max);
    }
}