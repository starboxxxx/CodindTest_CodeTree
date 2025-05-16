import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());

            if (pq.size() < 3) {
                System.out.println(-1);
            }
            else {
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();

                long num = (long) a * b * c;
                System.out.println((int) num);
                pq.add(a);
                pq.add(b);
                pq.add(c);
            }
        }
    }
}