import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

public class Main {
    public static TreeSet<Integer> set;
    public static HashMap<Integer, Integer> map;
    public static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        Point[] point = new Point[n];
        set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            point[i] = new Point(x, y);
            set.add(x);
            set.add(y);
        }
        
        map = new HashMap<>();
        prefixSum = new int[5002][5002];

        int cnt = 1;
        for (Integer num : set) {
            map.put(num, cnt++);
        }
        
        for (int i = 0; i<n; i++) {
            int x = point[i].x;
            int y = point[i].y;

            int newX = map.get(x);
            int newY = map.get(y);

            prefixSum[newX][newY]++;
        }

        for (int i = 1; i<=cnt; i++) {
            for (int j = 1; j<=cnt; j++) {
                prefixSum[i][j] += prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        for (int i = 0; i<q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int newX1 = getLowerBoundary(x1);
            int newY1 = getLowerBoundary(y1);
            int newX2 = getUpperBoundary(x2);
            int newY2 = getUpperBoundary(y2);

            int ans = getSum(newX1, newY1, newX2, newY2);
            System.out.println(ans);
        }
    }

    public static int getLowerBoundary(int x) {
        if (set.ceiling(x) != null) {
            return map.get(set.ceiling(x));
        }

        return set.size()+1;
    }

    public static int getUpperBoundary(int x) {
        if (set.floor(x) != null) {
            return map.get(set.floor(x));
        }

        return 0;
    }

    public static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
    }
}