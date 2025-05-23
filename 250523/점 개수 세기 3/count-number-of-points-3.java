import java.util.*;

class Point {
    long num;
    int cnt;

    public Point (long num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();

        TreeSet<Integer> map = new TreeSet<>();
        HashMap<Integer, Integer> mapper = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.add(a);
        }

        int cnt = 1;
        for (Integer num : map) {
            mapper.put(num, cnt);
            cnt++;
        }

        for (int i = 0; i<q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int newA = mapper.get(a);
            int newB = mapper.get(b);

            System.out.println(newB - newA + 1);
        }
        
        
    }
}