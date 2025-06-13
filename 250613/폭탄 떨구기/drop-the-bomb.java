import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        Arrays.sort(pos);

        int left = 0;
        int right = 1000000000;
        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            int current = pos[0] + 2 * mid;
            int count = 1;            
            boolean can = true;
            int i = 1;
            while (count <= k && i < n) {
                if (pos[i] > current) {
                    count++;
                    current = pos[i] + (2 * mid);
                }
                i++;
            }

            if (count <= k) {
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