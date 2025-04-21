import java.util.Scanner;
public class Main {

    public static int n;
    public static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        num = new int[n];

        for (int i = 0; i<n; i++) {
            num[i] = -1;
        }

        System.out.print(dp(n-1));
    }

    public static int dp(int k) {

        if (num[k] != -1) {
            return num[k];
        }

        if (k <= 1) {
            num[k] = 1;
        }
        else {
            num[k] = dp(k-1) + dp(k-2);
        }

        return num[k];
    }
}