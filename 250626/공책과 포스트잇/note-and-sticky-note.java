import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 0;
        int right = 100000;

        int answer = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            TreeSet<Integer> set = new TreeSet<>();

            int result = 0;
            for (int i = 0; i<n; i++) {
                if (arr[i] < mid) {
                    set.add(arr[i]);
                }
                else {
                    result++;
                }
            }

            int count = k * l;

            while (true) {
                int num = set.last();

                count -= (mid-num);

                if (count >= 0) {
                    result++;
                }
                else {
                    break;
                }
            }

            if (result >= mid) {
                left = mid+1;
                answer = Math.max(answer, mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(answer);
    }
}