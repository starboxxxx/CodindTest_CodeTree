import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = sc.next();

        while (true) {

            int n = sc.nextInt();
            int len = result.length();

            if (n >= len) {
                result = result.substring(0, len-1);
                System.out.println(result);
            }
            else {
                result = result.substring(0,n) + result.substring(n+1, len);
                System.out.println(result);
            }

            if (result.length() <= 1) {
                break;
            }
        }

    }
}