import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] visited = new int[10001];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        TreeSet<Integer> set = new TreeSet<>();
        int total = 0;
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            visited[num]++;
            total += num;
            pq.add(num);
        }  

        double max = 0.0;
        int count = n;
        for (int i = 0; i<n-2; i++) {
            
            int q = arr[i];
            total -= q;
            visited[q]--;
            count--;

            while (true) {
                if (visited[pq.peek()] != 0) {
                    break;
                }
                pq.poll();
            }
                max = Math.max(max, (double)(total - pq.peek()) / (count-1));
            
        }

        System.out.printf("%.2f", max);
    }
}