import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int total = 0;

        for (int i = 0; i<n; i++) {

            if (pq.size() < 2) {
                break;
            }
            int a = pq.poll();
            int b = pq.poll();

            pq.add(a+b);
            total += (a+b);
        }

        System.out.print(total);
    }
}