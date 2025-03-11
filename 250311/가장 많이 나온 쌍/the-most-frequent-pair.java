import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int max = 0;
        
        for (int i = 0; i<M; i++) {
            int x = a[i];
            int y = b[i];
            int count = 0;

            for (int j = 0; j<M; j++) {
                if ((a[j] == x && b[j] == y)
                || (a[j] == y && b[j] == x)) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        System.out.print(max);
    }
}