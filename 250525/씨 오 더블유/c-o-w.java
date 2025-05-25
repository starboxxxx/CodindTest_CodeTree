import java.util.Scanner;
public class Main {

    public static int n;
    public static long[][] nums;
    public static char[] alpha;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String str = sc.next();
        alpha = new char[n+1];

        for (int i = 1; i<=n; i++) {
            alpha[i] = str.charAt(i-1);
        }

        nums = new long[n+1][3];

        System.out.print(dp());
    }

    public static long dp() {
        for (int i = 1; i<=n; i++) {
            char a = alpha[i];

            nums[i][0] = nums[i-1][0];
            nums[i][1] = nums[i-1][1];
            nums[i][2] = nums[i-1][2];

            if (a == 'C') {
                nums[i][0] = nums[i-1][0] + 1;
            }

            else if (a == 'O') {
                nums[i][1] += nums[i-1][0]; 
            }

            else {
                nums[i][2] += nums[i-1][1];
            }
        }

        return nums[n][2];
    }
}