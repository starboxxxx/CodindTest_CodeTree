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
            
            if (set.contains(chair)) {
                for (int j =chair-1; j>=1; j--) {
                    if (!set.contains(j)) {
                        set.add(j);
                        count++;
                        break;
                    }
                    else if (j == 1) {
                        can = false;
                    }
                }

            }
            else {
                set.add(chair);
                count++;
            }
        }
        System.out.print(count);
    }
}