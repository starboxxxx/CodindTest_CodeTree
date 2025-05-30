import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candy = new int[1000001];

        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            int position = sc.nextInt();

            candy[position] += count;
        }

        int sum = 0;
        for (int i = 0; i<=2*k; i++) {
            if (i >= 1000001) {
                break;
            }
            sum += candy[i];
        }

        int max = sum;
        sum -= candy[0];

        for (int i = 1; i<=1000000; i++) {
            int p = i + 2*k;
            if (p >= 1000001) {
                break;
            }
            sum += candy[p];
            max = Math.max(max, sum);
            sum -= candy[i];
        }

        System.out.print(max);
        

    }
}