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

            int chair = sc.nextInt();
            
            if (!set.contains(chair)) {
                set.add(chair);
                count++;
            }
            else {

                int num = chair;
                
                while (true) {
                    
                    if (set.lower(num) == null) {
                        can = false;
                        break;
                    }

                    int k = set.lower(num);

                    if (k != num-1) {
                        count++;
                        set.add(num-1);
                        break;
                    }

                    num = k;
                }

                if (can == false) {
                    break;
                }
            }
        }
        System.out.print(count);
    }
}