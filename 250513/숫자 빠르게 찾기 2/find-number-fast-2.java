import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            if (set.ceiling(k) == null) {
                System.out.println(-1);
            } 
            else {
                System.out.println(set.ceiling(k));
            }

        }


    }
}