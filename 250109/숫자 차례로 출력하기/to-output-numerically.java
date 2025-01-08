import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int i = 1;

        num1(N);
        System.out.println();
        num2(i, N);
    }

    public static void num1(int N) {
        if (N == 0) {
            return;
        }
        num1(N-1);
        System.out.print(N + " ");
    }

    public static void num2(int i, int N) {
        if (i == N+1) {
            return;
        }
        num2(i+1, N);
        System.out.print(i + " ");
    } 
}