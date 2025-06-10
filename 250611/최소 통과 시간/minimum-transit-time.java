import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        
        long left = 1;
        long right = n * 1000000000;
        long answer = n * 1000000000;

        while (left <= right) {

            long mid = (left + right) / 2;

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