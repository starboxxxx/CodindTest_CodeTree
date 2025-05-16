import java.util.*;

class Temp implements Comparable<Temp> {
    int num;

    public Temp(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Temp n) {
        if (Math.abs(this.num) != Math.abs(n.num)) {
            return Math.abs(this.num) - Math.abs(n.num);
        }
        return this.num - n.num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                pq.add(new Temp(x));
            }
            else {
                if (pq.size() == 0) {
                    System.out.println(0);
                }
                else {
                    Temp temp = pq.poll();
                    System.out.println(temp.num);
                }
            }
        }
    }
}