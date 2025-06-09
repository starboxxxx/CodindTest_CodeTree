import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long max = Long.MIN_VALUE;
        long left = 1;
        long right = 10000000000L;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * (mid+1) / 2 <= s) {
                left = mid+1;
                max = Math.max(max, mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(max);
        
    }
}