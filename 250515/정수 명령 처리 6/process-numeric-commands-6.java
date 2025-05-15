import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i<n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int A = sc.nextInt();
                pq.add(-A);
            }

            else if (command.equals("pop")) {
                System.out.println(-pq.poll());
            }

            else if (command.equals("size")) {
                System.out.println(pq.size());
            }
            else if (command.equals("empty")) {
                if (pq.isEmpty()){
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else {
                System.out.println(-pq.peek());
            }
        }
    }
}