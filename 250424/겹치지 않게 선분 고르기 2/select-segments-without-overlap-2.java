import java.util.Scanner;
public class Main {

    public static int n;
    public static int[][] segments;
    public static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            count[i] = 1;
        }

        System.out.print(dp());

    }

    public static int dp() {

        int max = 0;

        for (int i = 1; i<n; i++) {
            int count = 1;
            int start = segments[i][0];
            int end = segments[i][1];

            for (int j = 0; j<i; j++) {
                int s = segments[j][0];
                int e = segments[j][1];

                if (s > end || e < start) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}