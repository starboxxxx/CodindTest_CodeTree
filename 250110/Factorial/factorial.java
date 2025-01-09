import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(factorial(N));

    }

    public static int factorial(int N) {
        if (N == 1) {
            return 1;
        }

        return factorial(N-1) * N;
    }
}