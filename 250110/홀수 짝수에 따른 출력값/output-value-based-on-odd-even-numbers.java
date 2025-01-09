import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.print(total1(N));

    }

    public static int total1(int N) {
        if (N == 1) {
            return 1;
        }
        else if (N == 2) {
            return 2;
        }
        return total1(N-2) + N;
    }
}