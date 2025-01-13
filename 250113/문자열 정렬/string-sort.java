import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String msg = sc.next();

        char[] alpha = msg.toCharArray();

        Arrays.sort(alpha);

        String sortedMsg = new String(alpha);

        System.out.print(sortedMsg);
    }
}