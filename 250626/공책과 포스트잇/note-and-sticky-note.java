import java.util.Scanner;
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

            int[] count = new int[100001];

            boolean can = false;
            for (int i = 0; i<n; i++) {
                count[arr[i]]++;

                if (count[arr[i]] >= mid) {
                    can = true;
                    break;
                }
            }

            if (can) {
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