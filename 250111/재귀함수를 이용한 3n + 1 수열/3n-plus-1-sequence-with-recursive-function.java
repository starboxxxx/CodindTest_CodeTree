import java.util.*;

public class Main {
    public static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(printResult(n));
    }

    public static int printResult(int n) {
        if (n==1) {
            return total;
        }

        else if (n % 2 == 0) {
            total++;
            return printResult(n / 2);
        }

        else {
            total++;
            return printResult(n * 3 + 1);
        }
    }
}