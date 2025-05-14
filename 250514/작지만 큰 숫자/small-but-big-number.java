import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] sequence = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();

            if (set.floor(num) == null) {
                System.out.println(-1);
            }
            else {
                System.out.println(set.floor(num));
                set.remove(set.floor(num));
            }
        }
        
    }
}