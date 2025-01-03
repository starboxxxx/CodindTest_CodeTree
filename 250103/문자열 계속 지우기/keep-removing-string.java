import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        String B = sc.next();

        String result = "";
        
        int i = 0;

        int len = B.length();

        while (true) {

            if (A.substring(i, i+len).equals(B)) {
                A = A.substring(0,i) + A.substring(i+len, A.length());
                i = 0;
                len = B.length();
            }

            else if (i == A.length()-len) {
                break;
            }

            else {
                i++;
            }
        }

        System.out.print(A);
    }
}