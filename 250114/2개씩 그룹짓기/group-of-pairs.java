import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int K = N * 2;
        int[] num = new int[K];

        for (int i = 0; i<K; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        int max = 0;

        for (int i = 0; i<N; i++) {
            if (num[i] + num[K-1-i] > max) {
                max = num[i] + num[K-1-i];
            }
        }

        System.out.print(max);

    }
}