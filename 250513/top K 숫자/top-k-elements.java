import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        for (int i = 1; i<=k; i++) {
            System.out.print(set.last() + " ");
            set.remove(set.last());
        }
        
    }
}