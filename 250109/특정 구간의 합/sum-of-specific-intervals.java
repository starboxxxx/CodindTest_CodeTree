import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i<=m; i++) {
            int a1 = sc.nextInt() - 1;
            int a2 = sc.nextInt() - 1;

            calculate(a1, a2, A);
        }
    }

    public static void calculate(int a1, int a2, int[] A) {
        int total = 0;
        for (int i = a1; i<=a2; i++) {
            total += A[i];
        }
        System.out.println(total);
    }
}