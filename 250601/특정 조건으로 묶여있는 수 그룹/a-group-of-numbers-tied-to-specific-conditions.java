import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        // 각 인덱스별로, 끝나는 최대 구간 크기 저장
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // 왼쪽에서 최대 구간 구하기 (0 ~ i까지)
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (arr[r] - arr[l] > k) l++;
            maxLeft[r] = r - l + 1;
        }

        // 왼쪽 최대값 누적
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i], maxLeft[i - 1]);
        }

        // 오른쪽에서 최대 구간 구하기 (i ~ n-1까지)
        int r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (arr[r] - arr[i] > k) r--;
            maxRight[i] = r - i + 1;
        }

        // 오른쪽 최대값 누적
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i], maxRight[i + 1]);
        }

        // 두 구간의 최대 합 구하기
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, maxLeft[i] + maxRight[i + 1]);
        }

        // 한 그룹만 쓰는 경우도 고려
        result = Math.max(result, maxLeft[n - 1]);

        System.out.println(result);
    }
}