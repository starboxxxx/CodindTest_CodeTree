import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] num = new int[N];

        for (int i = 0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        check(num);
    }

    public static void check(int[] num) {
        for (int i = 0; i<num.length; i++) {
            if (num[i] < 0) {
                int a = 0 - num[i];
                num[i] = a;
            }
            System.out.print(num[i] + " ");
        }
    }
}