import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 0; i<=10; i++) {
            for (int j = 0; j<=10; j++) {
                for (int z = 0; z<=10; z++) {
                    boolean success = true;

                    for (int l = 0; l<n; l++) {
                        if (x[l] == i || x[l] == j || x[l] == z) {
                            continue;
                        }
                        success = false;
                        break;
                    }

                    if (success) {
                        ans = 1;
                    }

                    success = true;

                    for (int l = 0; l<n; l++) {
                        if (x[l] == i || x[l] == j || y[l] == z) {
                            continue;
                        }
                        success = false;
                        break;
                    }

                    if (success) {
                        ans = 1;
                        break;
                    }

                    success = true;

                    for (int l = 0; l<n; l++) {
                        if (x[l] == i || y[l] == j || y[l] == z) {
                            continue;
                        }
                        success = false;
                        break;
                    }

                    if (success) {
                        ans = 1;
                    }

                    success = true;

                    for (int l = 0; l<n; l++) {
                        if (y[l] == i || y[l] == j || y[l] == z) {
                            continue;
                        }

                        success = false;
                        break;
                    }

                    if (success) {
                        ans = 1;
                    }
                }
            }
        }

        System.out.print(ans);

    }
}