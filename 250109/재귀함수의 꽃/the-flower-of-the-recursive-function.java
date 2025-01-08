import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        printNum1(N);
        printNum2(N);
    }

    public static void printNum1(int N) {
        if (N == 0) {
            return;
        }
        System.out.print(N + " ");
        printNum1(N-1);
    }

    public static void printNum2(int N) {
        if (N == 0) {
            return;
        }
        printNum2(N-1);
        System.out.print(N + " ");
    }
}