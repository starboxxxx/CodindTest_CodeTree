import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int[] block = new int[N];

        for (int i = 0; i<k; i++) {
            int A = sc.nextInt()-1;
            int B = sc.nextInt()-1;

            for (int j = A; j<=B; j++) {
                block[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i<N; i++) {
            if (block[i] > max) {
                max = block[i];
            }
        }

        System.out.print(max);
    }
}