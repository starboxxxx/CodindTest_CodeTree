import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int k = sc.nextInt();

        int[] num = new int[N];

        for (int i = 0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        System.out.print(num[k-1]);
    }
}