import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        String a = "";
        String b = "";
        for (int i = 0; i<n1; i++) {
            a  = a + String.valueOf(sc.nextInt());
        }
        for (int i = 0; i<n2; i++) {
            b = b + String.valueOf(sc.next());
        }

        System.out.print(check(n1, n2, a, b));
    }

    public static String check(int n1, int n2, String a, String b) {

        for (int i = 0; i<=n1-n2; i++) {
            if (a.substring(i, i+n2).equals(b)) {
                return "Yes";
            }
        }

        return "No";
    }
}