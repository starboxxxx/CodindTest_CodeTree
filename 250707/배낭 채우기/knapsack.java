import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[][] je;
    public static int[] counts;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        je = new int[n][2];
        counts = new int[m+1];

        for (int i = 0; i<=m; i++) {
            counts[i] = Integer.MIN_VALUE;
        }
        counts[0] = 0;

        for (int i = 0; i < n; i++) {
            je[i][0] = sc.nextInt();
            je[i][1] = sc.nextInt();
        }

        System.out.print(dp());
    }

    public static int dp() {

        for (int i = 0; i<n; i++) {
            for (int j = m; j>=0; j--) {
                if (j-je[i][0] < 0 || counts[j-je[i][0]] == Integer.MIN_VALUE) {
                    continue;
                }
                counts[j] = Math.max(counts[j], counts[j-je[i][0]] + je[i][1]);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i<=m; i++) {
            max = Math.max(max, counts[i]);
        }

        return max;
    }
}