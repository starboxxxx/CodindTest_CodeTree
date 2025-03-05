import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[401];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int position = sc.nextInt();
            
            if (candies[position] != 0) {
                candies[position] += num;
            }
            else {
                candies[position] = num;
            }
        }

        int max = 0;

        for (int i = 0; i<=400-(2*k); i++) {
            int total = 0;
            for (int j = i; j<=i + (2*k); j++) {
                total += candies[j];
            }

            if (total > max) {
                max = total;

            }
        }

        System.out.print(max);
    }
}