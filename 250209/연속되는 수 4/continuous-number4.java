import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] num = new int[N];

        for(int i = 0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        int count = 0;
        int max = 0;

        for (int i = 0; i<N; i++) {
            if (i==0 || num[i]<=num[i-1]) {
                count = 1;
            }
            else {
                count++;
            }

            max = Math.max(max, count);
        }

        System.out.print(max);
    }
}