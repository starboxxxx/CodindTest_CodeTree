import java.util.Scanner;
public class Main {

    public static int n;
    public static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        if (n == 1 || n == 2) {
            System.out.print(1);
        }
        else {
            num = new int[n];
            num[0] = 1;
            num[1] = 1;
            System.out.print(dp(n-1));
        }
    }

    public static int dp(int k) {

        for (int i = 2; i<n; i++) {
            num[i] = num[i-1] + num[i-2];
        }

        return num[k];
    }
}