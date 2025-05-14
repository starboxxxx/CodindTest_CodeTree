import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        set.add(-1);
        set.add(n+1);

        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
            int max = Integer.MIN_VALUE;
            
            int num = -1;
            while (true) {
                if (set.higher(num) == null) {
                    break;
                }

                max = Math.max(max, set.higher(num)-num-1);
                num = set.higher(num);
            }

            System.out.println(max);
        }
        

    }
}