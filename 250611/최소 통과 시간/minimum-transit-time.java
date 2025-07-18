import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        long[] arr = new long[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextLong();
        
        long left = 1;
        long right = n * 1000000000;
        long answer = n * 1000000000;

        while (left <= right) {

            long mid = (left + right) / 2L;

            long count = 0;

            for (int i = 0; i<m; i++) {
                count += (mid / arr[i]);
            }

            if (count >= n) {
                right = mid-1;
                answer = Math.min(answer, mid);
            }
            else {
                left = mid+1;
            }
        }

        System.out.print(answer);
    }
}