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

        int count = 0;
        for (int i = 0; i < n; i++) {

            int chair = sc.nextInt();
            
            if (set.floor(chair) == null) {
                break;
            }

            int num = set.floor(chair);

            set.remove(num);
            count++;
        }
        System.out.print(count);
    }
}