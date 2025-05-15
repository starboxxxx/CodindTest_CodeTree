import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();        
        for (int i = 0; i < N; i++) {
            pq.add(-sc.nextInt());
        }

        while (M-- > 0) {
            int num = -pq.poll();
            num--;
            pq.add(-num);
        }

        System.out.print(-pq.poll());
    }
}