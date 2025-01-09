import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print(pibonachi(N));
    }


    public static int pibonachi(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }

        return pibonachi(N-2) + pibonachi(N-1);
    }
}