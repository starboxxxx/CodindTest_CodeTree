import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(-sc.nextInt());
        }

        while (pq.size() >= 2) {

            int num1 = -pq.poll();
            int num2 = -pq.poll();

            if (num1 != num2) {
                int k = Math.abs(num1 - num2);
                pq.add(-k);
            }
        }

        if (pq.size() == 0) {
            System.out.print(-1);
        }
        else {
            System.out.print(-pq.peek());
        }
        
    }
}