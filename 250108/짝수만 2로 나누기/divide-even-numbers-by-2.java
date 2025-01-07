import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] num = new int[N];
        for (int i=0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        divide(num);
    }

    public static void divide(int[] num) {
        for (int i = 0; i<num.length; i++) {
            if (num[i] % 2 == 0) {
                num[i] /= 2;
            }
            System.out.print(num[i] + " ");
        }

    }
}