import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sum[0] = nums[0];

        for (int i = 1; i<n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        int[] partition = new int[7];

        for (int i = 0; i<n; i++) {
            partition[i] = -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            int k = sum[i] % 7;

            if (partition[k] == -1) {
                partition[k] = i;
            }
            else {
                max = Math.max(max, i-partition[k] + 1);
                partition[k] = i;
            }
        }

        System.out.print(max);
    }
}