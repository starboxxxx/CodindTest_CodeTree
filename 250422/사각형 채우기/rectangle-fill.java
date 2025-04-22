import java.util.Scanner;
public class Main {

    public static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count = new int[n+1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i<=n; i++) {
            count[i] = (count[i-1] + count[i-2]) % 10007;
        }

        System.out.print(count[n]);
    }
}