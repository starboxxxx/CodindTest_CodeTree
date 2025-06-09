import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
       
        long left = 1L;
        long right = Long.MAX_VALUE;

        while (left <= right) {

            long mid = (left + right) / 2;

            long total = mid - ((mid / 3L) + (mid / 5L) - (mid / 15L));

            if (total == n) {
                System.out.print(mid);
                break;
            }
            else if (total > n) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
    }
}