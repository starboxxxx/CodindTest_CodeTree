import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(printTotal(N));
    }

    public static int printTotal(int N) {

        if (N == 1) {
            return 1;
        }

        return printTotal(N-1) + N;
    }
}