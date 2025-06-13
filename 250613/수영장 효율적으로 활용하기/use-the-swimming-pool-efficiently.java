import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 1;
        int right = 144000000;

        int answer = Integer.MAX_VALUE;

        while (left <= right) {

            int mid = (left + right) / 2;

            int count = 1;
            int total = arr[0];
            int i = 1;

            while (i < n) {
                if (count > m) {
                    break;
                }

                if (total + arr[i] <= mid) {
                    total += arr[i];
                    i++;
                }
                else {
                    count++;
                    total = 0;
                }
            }

            if (count <= m) {
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