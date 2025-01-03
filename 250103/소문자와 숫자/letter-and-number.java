import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.next();

        for (int i = 0; i<msg.length(); i++) {
            int n = msg.charAt(i);
            if (n >= 65 && n <= 90) {
                System.out.print((char)(n+32));
            }
            else if (n>=97 && n<=122) {
                System.out.print((char)n);
            }
            else if (n>=49 && n<=57) {
                System.out.print((char)n);
            }
        }
    }
}