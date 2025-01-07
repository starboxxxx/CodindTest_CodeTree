import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = swap(n, m);
        System.out.print(num[0] + " " + num[1]);
    }

    public static int[] swap(int n, int m) {
        int tmp = n;
        n = m;
        m = tmp;

        int[] num = new int[]{n, m};
        return num;
    }
}