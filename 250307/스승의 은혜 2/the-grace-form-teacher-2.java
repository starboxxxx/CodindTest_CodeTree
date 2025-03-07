import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] price = new int[n];

        for (int i = 0; i<n; i++) {
            price[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            int total = 0;
            int count = 0;
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    total += (price[j] / 2);
                    count++;
                }
                else {
                    total += price[j];
                    count++;
                }

                if (total > b) {
                    count--;
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }

        System.out.print(max);
    }
}