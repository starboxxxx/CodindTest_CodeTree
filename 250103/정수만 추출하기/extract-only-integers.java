import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.next();
        String second = sc.next();

        for (int i = 0; i<first.length(); i++) {
            int n = first.charAt(i);
            if (n < 48 || n>57) {
                first = first.substring(0, i);
            }
        }

        for (int i = 0; i<second.length(); i++) {
            int n = second.charAt(i);
            if (n < 48 || n > 57) {
                second = second.substring(0, i);
            }
        }

        System.out.print(Integer.parseInt(first) + Integer.parseInt(second));
    }
}