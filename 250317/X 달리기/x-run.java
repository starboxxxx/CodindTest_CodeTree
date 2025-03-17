import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        int distance = 0;
        int time = 0;

        if (x % 2 == 0) {
            distance = 3;
            time = 3;
        }
        else {
            distance = 2;
            time = 2;
        }

        for (int i = 2; i<10000; i++) {
            int total = distance;
            for (int j = 2; j<=i; j++) {
                total += j * 2;
            }

            if (total + i+1 == x) {
                time += (i-1) * 2 + 1;
                break;
            }
        }

        System.out.print(time);
    }
}