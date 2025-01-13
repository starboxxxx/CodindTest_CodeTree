import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] num = new int[100];

        int cnt = 0;

        for (int i = 0; i<n; i++) {
            num[i] = sc.nextInt();

            Arrays.sort(num, 0, i+1);

            if ((i+1) % 2 != 0 ) {
                System.out.print(num[i/2] + " ");
            }
        }
    }
}