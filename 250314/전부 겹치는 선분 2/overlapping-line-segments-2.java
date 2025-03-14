import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        for (int i = 0; i<n; i++) {
            int start = 0;
            int end = Integer.MAX_VALUE;
            boolean isTrue = false;
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    if (j == n-1) {
                        System.out.print("Yes");
                        isTrue = true;
                        break;
                    }
                    else {
                        continue;
                    }
                }

                if (x1[j] > end || x2[j] < start) {
                    break;
                }
                else {
                    if (j == n-1) {
                        System.out.print("Yes");
                        isTrue = true;
                        break;
                    }
                    start = Math.max(start, x1[j]);
                    end = Math.min(end, x2[j]);
                }
            }
            if (isTrue) {
                break;
            }


            if (i == n-1) {
                System.out.print("No");
            }
        }
    }
}