import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] num = result(a, b);

        System.out.print(num[0] + " " + num[1]);
    }

    public static int[] result(int a, int b) {
        if (a>=b) {
            a += 25;
            b *= 2;
        }
        else {
            a *= 2;
            b += 25;
        }

        int[] num = new int[]{a, b};
        return num;
    }
}