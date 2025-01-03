import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        for (int i = 1; i<=n; i++) {
            total += sc.nextInt();
        }

        String result = Integer.toString(total);

        result = result.substring(1, result.length()) + result.substring(0, 1);
        System.out.print(result);
    }
}