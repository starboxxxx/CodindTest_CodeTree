import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        count(a, b);
    }

    public static void count(int a, int b) {
        int total = 0;
        
        for (int i = a; i<=b; i++) {
            int count = 1;
            for (int j = 2; j<=i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                total += i;
            }
        }

        System.out.print(total);
    }
}