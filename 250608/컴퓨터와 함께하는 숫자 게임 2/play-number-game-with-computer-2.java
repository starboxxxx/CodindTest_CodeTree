import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (long i = a; i <=b; i++) {

            long left = 1;
            long right = m;
            long count = 0;

            while (left <= right) {
                
                count++;
                long mid = (left + right) / 2;
                if (mid == i) {
                    break;
                }
                else if (mid > i) {
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }

            min = Math.min(min, count);
            max = Math.max(max, count);
        }

         System.out.print(min + " " + max);
    }
}