import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {
            int num = sc.nextInt();

            if (set.higher(num) != null) {
                min = Math.min(min, set.higher(num) - num); 
            }

            if (set.lower(num) != null) {
                min = Math.min(min, num - set.lower(num)); 
            }

            set.add(num);

            System.out.println(min);
        }
        

    }
}