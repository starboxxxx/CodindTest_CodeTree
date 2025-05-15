import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                pq.add(num);
            }
            else {
                if (pq.size() == 0) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            
        }
    }
}