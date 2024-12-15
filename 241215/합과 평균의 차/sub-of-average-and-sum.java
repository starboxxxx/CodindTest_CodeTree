import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int total = (a + b + c);

        System.out.printf("%d\n%d\n%d", total, total / 3, total - (total/3));
    }
}