import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        String resultA = "";
        String resultB = "";
        for (int i = 0; i<A.length(); i++) {
            if (A.charAt(i) >= '0' && A.charAt(i) <= '9') {
                resultA += A.charAt(i);
            }
        }

        for (int i = 0; i<B.length(); i++) {
            if (B.charAt(i) >= '0' && B.charAt(i) <= '9') {
                resultB += B.charAt(i);
            }
        }

        System.out.print(Integer.parseInt(resultA) + Integer.parseInt(resultB));
    }
}