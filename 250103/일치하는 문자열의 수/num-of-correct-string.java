import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String A = sc.next();
        int total = 0;

        for (int i = 1; i<=n; i++) {
            if (A.equals(sc.next())) {
                total += 1;
            }
        }

        System.out.print(total);
    }
}