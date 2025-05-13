import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        boolean can = true;
        for (int i = 0; i < n; i++) {

            if (can == false) {
                break;
            }

            int chair = sc.nextInt();
            
            for (int j = chair; j>=1; j--) {
                if (!set.contains(j)) {
                    count++;
                    set.add(j);
                    break;
                }

                if (j == 1) {
                    can = false;
                    break;
                }
            }
        }
        System.out.print(count);
    }
}