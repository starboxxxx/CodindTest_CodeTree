import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            B.add(sc.nextInt());
        }

        for (int i = 1; i<=2*n; i++) {
            if (!B.contains(i)) {
                A.add(i);
            }
        }

        int count = 0;

        while (!B.isEmpty()) {
            int num = B.first();

            if (A.higher(num) == null) {
                A.remove(A.first());
            }
            else {
                A.remove(A.higher(num));
                count++;
            }

            B.remove(num);
        }


        System.out.print(count);
    }
}