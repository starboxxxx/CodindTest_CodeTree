import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String qs = sc.nextLine();

        for (int i=0; i<qs.length(); i++) {
            int n = qs.charAt(i);

            if (n>=65 && n<=90) {
                System.out.print((char)n);
            }
            else if (n>=97 && n<=122) {
                System.out.print((char)(n-32));
            }
        }
    }
}