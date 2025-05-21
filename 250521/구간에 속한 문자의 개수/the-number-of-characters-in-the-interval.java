import java.util.Scanner;

class Alpha {

    int a;
    int b;
    int c;

    public Alpha(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {

    public static char[][] alpha;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        alpha = new char[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String p = sc.next();
            for (int j = 1; j<=m; j++) {
                alpha[i][j] = p.charAt(j-1);
            }
        }

        Alpha[][] sum = new Alpha[n+1][m+1];

        for (int i = 0; i<=n; i++) {
            sum[i][0] = new Alpha(0, 0, 0);
        }

        for (int i = 0; i<=m; i++) {
            sum[0][i] = new Alpha(0, 0, 0);
        }

        sum[1][1] = count(1, 1);

        for (int i = 2; i<=n; i++) {
            Alpha alpha1 = count(i, 1);

            Alpha preview = sum[i-1][1];

            int a = preview.a + alpha1.a;
            int b = preview.b + alpha1.b;
            int c = preview.c + alpha1.c;

            sum[i][1] = new Alpha(a, b, c);
        }

        for (int i = 2; i<=m; i++) {
            Alpha alpha1 = count(1, i);

            Alpha preview = sum[1][i-1];

            int a = preview.a + alpha1.a;
            int b = preview.b + alpha1.b;
            int c = preview.c + alpha1.c;

            sum[1][i] = new Alpha(a, b, c);
        }

        for (int i = 2; i<=n; i++) {
            for (int j = 2; j<=m; j++) {

                Alpha x = sum[i-1][j];
                Alpha y = sum[i][j-1];
                Alpha z = sum[i-1][j-1];

                Alpha current = count(i, j);

                int a = x.a + y.a - z.a + current.a;
                int b = x.b + y.b - z.b + current.b;
                int c = x.c + y.c - z.c + current.c;

                sum[i][j] = new Alpha(a, b, c); 
            }
        }

        for (int i = 0; i < k; i++) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            Alpha p = sum[r2][c2];
            Alpha q = sum[r1-1][c2];
            Alpha r = sum[r2][c1-1];
            Alpha s = sum[r1-1][c1-1];

            int a = p.a - q.a - r.a + s.a;
            int b = p.b - q.b - r.b + s.b;
            int c = p.c - q.c - r.c + s.c;

            System.out.println(a + " " + b + " " + c);
        }
    }

    public static Alpha count (int i, int j) {
        
        Alpha k = new Alpha(0, 0, 0);
        if (alpha[i][j] == 'a') {
            k.a++;
        }
        else if (alpha[i][j] == 'b') {
            k.b++;
        }
        else {
            k.c++;
        }

        return k;
    }
}