import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        getNum(a, b);
    }

    public static void getNum(int a, int b) {
        int total = 1;
        for (int i = 0; i<b; i++) {
            total *= a;
        }

        System.out.print(total);
    }
}