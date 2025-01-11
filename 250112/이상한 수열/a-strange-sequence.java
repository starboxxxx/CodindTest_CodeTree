import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(printResult(N));
    }

    public static int printResult(int N) {
        if (N == 1) {
            return 1;
        }
        else if (N == 2) {
            return 2;
        }

        return printResult(N / 3) + printResult(N-1);
    }
}