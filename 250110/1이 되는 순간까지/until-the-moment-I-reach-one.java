import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(printCount(N));
    }

    public static int printCount(int N) {
        if (N == 1) {
            return 0;
        }

        else if (N % 2 == 0) {
            return printCount(N / 2) + 1;
        }
        else {
            return printCount(N / 3) + 1;
        }
    }
}