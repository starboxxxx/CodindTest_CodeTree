import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(getMin(a, b, c));

    }

    public static int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        min  = Math.min(min, c);

        return min;
    }
}