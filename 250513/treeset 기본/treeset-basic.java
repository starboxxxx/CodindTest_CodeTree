import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i<a; i++) {
            String command = sc.next();

            if (command.equals("add")) {
                int n = sc.nextInt();
                if (!set.contains(n)) {
                    set.add(n);
                }
            }

            else if (command.equals("remove")) {
                int n = sc.nextInt();
                if (set.contains(n)) {
                    set.remove(n);
                }
            }
            else if (command.equals("find")) {
                int n = sc.nextInt();
                if (set.contains(n)) {
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }
            }
            else if (command.equals("lower_bound")) {
                int n = sc.nextInt();

                if (set.ceiling(n) == null) {
                    System.out.println("None");
                }
                else {
                    System.out.println(set.ceiling(n));
                }
            }
            else if (command.equals("upper_bound")) {
                int n = sc.nextInt();

                if (set.higher(n) == null) {
                    System.out.println("None");
                }
                else {
                    System.out.println(set.higher(n));
                }
            }

            else if (command.equals("largest")) {
                if (set.size() == 0) {
                    System.out.println("None");
                }
                else {
                    System.out.println(set.last());
                }
            }
            else {
                if (set.size() == 0) {
                    System.out.println("None");
                }
                else {
                    System.out.println(set.first());
                }
            }
        }
    }
}