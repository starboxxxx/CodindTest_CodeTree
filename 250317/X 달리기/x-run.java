import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int distance = 2;
        int time = 2;

        for (int i = 10000; i>=0; i--) {
            int total = distance;
            for (int j = 2; j<=i; j++) {
                total += j * 2;
            }

            if (total + i+1 <= x) {
                System.out.print(i);
                time += (i-1) * 2 + 1;
                time += x - (total + i + 1);
                break;
            }
        }

        System.out.print(time);
    }
}