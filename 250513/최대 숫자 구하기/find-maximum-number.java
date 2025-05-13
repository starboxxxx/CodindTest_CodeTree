import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i<=m; i++) {
            set.add(i);
        }

        for (int i = 0; i < n; i++) {
            set.remove(sc.nextInt());
            System.out.println(set.last());
        }
        

    }
}