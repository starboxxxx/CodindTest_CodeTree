import java.util.*;

class People1 implements Comparable<People1> {
    int num;
    int a;
    int t;

    public People1(int num, int a, int t) {
        this.num = num;
        this.a = a;
        this.t = t;
    } 

    @Override
    public int compareTo(People1 p) {
        return this.a - p.a;
    }
}

class People2 implements Comparable<People2> {
    int num;
    int a;
    int t;

    public People2(int num, int a, int t) {
        this.num = num;
        this.a = a;
        this.t = t;
    } 

    @Override
    public int compareTo(People2 p) {
        return this.num - p.num;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<People1> pq1 = new PriorityQueue<>();
        PriorityQueue<People2> pq2 = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int a = sc.nextInt();
            int t = sc.nextInt();
            pq1.add(new People1(num, a, t));
        }

        People1 k = pq1.poll();
        pq2.add(new People2(k.num, k.a, k.t));
        
        int current = pq2.peek().a;

        while (true) {

            if (pq2.isEmpty() && pq1.isEmpty()) {
                break;
            }
            else if (pq2.isEmpty()) {
                People1 x = pq1.poll();

                pq2.add(new People2(x.num, x.a, x.t));
            }

            People2 people = pq2.poll();
            if (current > people.a) {
                max = Math.max(max, current - people.a);
                current += people.t;
            }
            else {
                current = people.a + people.t;
            }

            if (!pq1.isEmpty()) {
                while (true) {
                    if (pq1.isEmpty() || pq1.peek().a > current) {
                        break;
                    }

                    People1 p = pq1.poll();
                    pq2.add(new People2(p.num, p.a, p.t));
                }   
            }

        }

        System.out.print(max);
        
    }
}