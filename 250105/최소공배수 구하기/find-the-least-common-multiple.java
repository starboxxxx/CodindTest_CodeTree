import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        getNum(n, m);
    }

    public static void getNum(int n, int m) {
        int num = Math.max(n, m);

        while (true) {
            if (num % n == 0 && num % m == 0) {
                System.out.print(num);
                break;
            }

            num++;
        }
    }
}