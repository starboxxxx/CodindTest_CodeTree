import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];

        for (int i = 0; i<A.length; i++) {
            A[i] = sc.nextInt();
        }

        calculate(A, m);
        
    }

    public static void calculate(int[] A, int m) {
        int total = 0;
        while (true) {
            if (m == 1) {
                total += A[m-1];
                break;
            }

            else if (m % 2 == 1) {
                total += A[m-1];
                m -= 1;
            }
            else {
                total += A[m-1];
                m /= 2;
            }
        }
        System.out.print(total);
    }
}