import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tMax = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        int left = 0;
        int right = n-1;
        int answer = n+1;

        while (left <= right) {
            int mid = (left + right) / 2;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i<mid; i++) {
                pq.add(d[i]);
            }

            int current = 0;
            int index = mid+1;
            int max = 0;
            while (!pq.isEmpty()) {
                int time = pq.poll();
                if (index < n) {
                    pq.add(time + d[index]);
                    max = Math.max(max, time + d[index]);
                    index++;
                }
            }

            if (max <= tMax) {
                right = mid - 1;
                answer = Math.min(answer, mid+1);
            }
            else {
                left = mid+1;
            }
        }

        System.out.print(answer);
    }
}