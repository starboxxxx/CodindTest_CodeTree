import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        check(s);

    }

    public static void check(String s) {
        String a = "";

        for (int i = s.length()-1; i>=0; i--) {
            String o = String.valueOf(s.charAt(i));
            a += o;
        }

        if (s.equals(a)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}