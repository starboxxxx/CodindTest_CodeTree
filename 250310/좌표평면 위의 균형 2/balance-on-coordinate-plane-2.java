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

        int M = Integer.MAX_VALUE;

        for (int i = 0; i<=100; i = i+2) {
            for (int j = 0; j<=100; j = j+2) {
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;

                for (int z = 0; z<n; z++) {
                    if (x[z] > i && y[z] > j) {
                        a++;
                    }

                    else if (x[z] < i && y[z] > j) {
                        b++;
                    }

                    else if (x[z] < i && y[z] < j) {
                        c++;
                    }
                    else {
                        d++;
                    }
                }
                int max = 0;
                if (a > max) {
                    max = a;
                }
                
                if (b > max) {
                    max = b;
                }

                if (c > max) {
                    max = c;
                }

                if (d > max) {
                    max = d;
                }

                if (max < M) {
                    M = max;
                }        
            }
        }

        System.out.print(M);
    }
}