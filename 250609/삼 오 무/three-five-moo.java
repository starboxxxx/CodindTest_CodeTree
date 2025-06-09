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
                if (mid % 3 != 0 && mid % 5 != 0) {
                    System.out.print(mid);
                }
                else {
                    System.out.print(mid-1);
                }
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