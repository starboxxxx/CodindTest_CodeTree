import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        int total = 0;

        for (int i = 0; i<A.length(); i++) {
            int n = A.charAt(i);
            String k = String.valueOf(A.charAt(i));
            if (n >= 48 && n<=57) {
                total+= Integer.parseInt(k);
            }
        }
        System.out.print(total);
    }
}