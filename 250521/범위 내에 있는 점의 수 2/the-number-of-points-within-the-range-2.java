import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] points = new int[1000001];
        int[] sum = new int[1000001];
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            points[k] = 1;
        }

        sum[0] = points[0];

        for (int i = 1; i<=1000000; i++) {
            if (points[i] == 1) {
                sum[i] = sum[i-1] + 1;
            }

            else {
                sum[i] = sum[i-1];
            }
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            
            System.out.println(sum[b] - sum[a] + points[a]);
        }
    }
}