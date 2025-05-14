import java.util.*;

class Problem implements Comparable<Problem> {
    int num;
    int level;

    public Problem(int num, int level) {
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Problem p) {
        if (this.level == p.level) {
            return this.num - p.num;
        }

        return this.level - p.level;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Problem> set = new TreeSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            set.add(new Problem(p, l));
        }


        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("rc")) {
                int x = sc.nextInt();

                if (x == 1) {
                    System.out.println(set.last().num);
                }
                else {
                    System.out.println(set.first().num);
                }

            } 
            else if (command.equals("ad")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                set.add(new Problem(p, l));

            }
            else {
                int p = sc.nextInt();
                int l = sc.nextInt();
                
                set.remove(new Problem(p, l));
            }
        }
        
    }
}