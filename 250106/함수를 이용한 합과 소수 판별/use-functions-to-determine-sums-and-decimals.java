import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(getResult(a, b));
    }

    public static int getResult(int a, int b) {
        int result = 0;
        for (int i = a; i<=b; i++) {
            int count = 1;
            for (int j = 2; j<=i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                int total = 0;
                String num = Integer.toString(i);
                for (int j = 0; j<num.length(); j++) {
                    total += num.charAt(j) - '0';
                }
                if (total % 2 == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}