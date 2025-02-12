import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int total = printTotal(N);
        System.out.print(total);
    }

    public static int printTotal(int N) {
        if (N < 10) {
            return N * N;
        }

        return printTotal(N / 10) + (N % 10) * (N % 10);
    }
}