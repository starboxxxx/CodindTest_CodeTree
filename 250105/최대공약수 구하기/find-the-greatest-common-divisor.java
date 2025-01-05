import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        getNum(n, m);

    }

    public static void getNum(int n, int m) {
        int num = 1;
        if (n >= m) {
            for (int i = 1; i<=m; i++) {
                if (n % i == 0 && m % i == 0) {
                    num = i; 
                }
            }
        }
        else {
            for (int i = 1; i<=n; i++) {
                if (n % i == 0 && m % i == 0) {
                    num = i;
                }
            }
        }
        System.out.print(num);
    }
}