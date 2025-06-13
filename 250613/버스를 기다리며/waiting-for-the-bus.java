import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        
        Arrays.sort(t);

        int left = 0;
        int right = 1000000000;

        int answer = Integer.MAX_VALUE;

        while (left <= right) {

            int mid = (left + right) / 2;

            int i = 1;
            int current = t[0] + mid;
            int count = 1;
            int bus = 1;

            while (i < n && bus <= m) {
                if (count <= c && t[i] <= current) {
                    count++;
                    i++;
                }

                else {
                    current = t[i] + mid;
                    count = 0;
                    bus++;
                }
            }

            if (bus <= m) {
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