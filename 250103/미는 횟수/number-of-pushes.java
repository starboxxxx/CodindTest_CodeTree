import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int total = 0;

        while (true) {
            if (A.equals(B)) {
                System.out.print(total);
                break;
            }
            else if (total == A.length()) {
                System.out.print(-1);
                break;
            }

            A = A.substring(A.length()-1, A.length()) + A.substring(0, A.length()-1);
            total ++;
        }
    }
}