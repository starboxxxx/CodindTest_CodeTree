import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int s = sc.nextInt();
        int result = 0;

        int[] digits = new int[20];

        int cnt = 0;

        while (true) {

            if (N < s) {
                digits[cnt] = N % s;
                break;
            }
            
            digits[cnt++] = N % s;
            N /= s;
        }


        for (int i = cnt; i>=0; i--) {
            System.out.print(digits[i]);
        }
    }
}