import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        long n = sc.nextLong();
        long k = sc.nextLong();
        
        long low = 1;                        // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        long high = n * n;                    // 답이 될 수 있는 가장 큰 숫자 값을 설정합니다.
        long ans = n * n;                   // 답을 저장합니다.

        while (low <= high) {

            long mid = (low + high) / 2;

            long val = 0;
            for (int i = 1; i<=n; i++) {
                val += Math.min(n, mid / i);
            }

            if (val >= k) {
                high = mid-1;
                ans = Math.min(ans, mid);
            }
            else {
                low = mid + 1;
            }
        }

        System.out.print(ans);
        
    }
}