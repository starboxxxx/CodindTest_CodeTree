import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int distance = 2;
        int time = 2;

        for (int i = 10000; i>=2; i--) {
            int total = distance;
            int t = time;
            for (int j = 2; j<=i; j++) {
                total += j * 2;
            }

            if (total + i+1 <= x) {
                int left = x - (total + i + 1);
                t += (i-1) * 2 + 1;
                while (true) {
                    if (left <= i) {
                        t += 1;
                        break;
                    }
                    left -= i;
                    t += 1;
                }
                time = t;
                break;
            }
        }

        System.out.print(time);
    }
}