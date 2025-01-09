import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int k = sc.nextInt();

        System.out.print(maxNum(n, k));
    }

    public static int maxNum(int n, int k) {
        
        if (n == 1) {
            return k;
        }

        else {
            int num = sc.nextInt();
            if (num > k) {
                k = num;
            }
        }

        return maxNum(n-1, k);
    }


}