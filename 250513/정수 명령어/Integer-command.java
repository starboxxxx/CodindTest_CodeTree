import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        TreeSet<Integer> set;
        
        while (t-- != 0) {
            int k = sc.nextInt();
            set = new TreeSet<>();

            for (int i = 0; i<k; i++) {
                char c = sc.next().charAt(0);
                int n = sc.nextInt();
                if (c == 'I') {
                    set.add(n);
                }
                else {
                    if (!set.isEmpty()) {
                        if (n == 1) {
                            set.remove(set.last());
                        }
                        else {
                            set.remove(set.first());
                        }
                    }
                }
            }
            if (set.isEmpty()) {
                    System.out.println("EMPTY");
            }
            else {
                System.out.println(set.last() + " " + set.first());
            }
        }
    }
}