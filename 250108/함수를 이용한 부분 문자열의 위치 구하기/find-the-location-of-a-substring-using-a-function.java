import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String total = sc.next();
        String target = sc.next();

        exist(total, target);
    }

    public static void exist(String total, String target) {

        for (int i = 0; i<=total.length()-target.length(); i++) {
            if (total.substring(i, i + target.length()).equals(target.substring(0, target.length()))) {
                System.out.print(i);
                break;
            }
            else if (i == total.length() - target.length()) {
                System.out.print(-1);
            }
        }
    }
}