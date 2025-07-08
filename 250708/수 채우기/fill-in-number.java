import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int count = 0;

        count += (n/5);

        if (n % 5 == 0) {
            System.out.print(count);
        }

        else {
            for (int i = count; i>=0; i--) {
                int x = (n - (i * 5)) / 2;
                int y = (n - (i * 5)) % 2;
                if (y == 0) {
                    System.out.print(i + x);
                    break;
                }
            }
        }
    }
}