import java.util.*;

class Node {
    int index;
    int L;
    int C;

    public Node (int index, int L, int C) {
        this.index = index;
        this.C = C;
        this.L = L;
    }
}

class Element implements Comparable<Element> {
    int A;
    int B;
    int time;
    int index;

    public Element (int A, int B, int time, int index) {
        this.A = A;
        this.B = B;
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo (Element e) {
        return this.time - e.time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            int L = sc.nextInt();
            int C = sc.nextInt();
            
            graph[I].add(new Node(J, L, C));
            graph[J].add(new Node(I, L, C));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();


        HashMap<Integer, Integer>[] time = new HashMap[n+1];

        for (int i = 1; i<=n; i++) {
            time[i] = new HashMap<>();
        }

        time[1].put(1000000, 0);

        pq.add(new Element(1000000, 0, 0, 1));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int A = e.A;
            int B = e.B;
            int minTime = e.time;
            int minIndex = e.index;

            if (minTime > time[minIndex].getOrDefault(A, Integer.MAX_VALUE)) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {
                int L = graph[minIndex].get(i).L;
                int C = graph[minIndex].get(i).C;
                int targetIndex = graph[minIndex].get(i).index;

                int newA = Math.min(A, C);
                int newB = B + L;

                int newTime = newB + x / newA;

                if (time[targetIndex].getOrDefault(A, Integer.MAX_VALUE) > newTime) {
                    time[targetIndex].put(newA, newTime);

                    pq.add(new Element(newA, newB, newTime, targetIndex));
                }
            }
        }


        int min = Integer.MAX_VALUE;

        for (int t : time[n].values()) {
            min = Math.min(min, t);
        }
        System.out.print(min);
    }
}