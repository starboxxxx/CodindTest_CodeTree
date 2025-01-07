import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        check(A);
    }

    public static void check(String A) {
        boolean end = false;
        for (int i = 0; i<A.length()-1; i++) {
            for (int j = i + 1; j< A.length(); j++) {
                if (A.charAt(i) != A.charAt(j)) {
                    System.out.print("Yes");
                    end = true;
                    break;
                }
            }
            if (end == true) {
                break;
            }
            else if (i == A.length() - 2) {
                System.out.print("No");
            }
        }
    }
}