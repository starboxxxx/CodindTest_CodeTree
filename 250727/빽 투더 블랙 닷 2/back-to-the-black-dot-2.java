import java.util.*;

class Node {
    int index;
    long dist;

    public Node (int index, long dist) {
        this.index = index;
        this.dist = dist;
    }
}

class Element implements Comparable<Element> {
    long dist;
    int index;

    public Element (long dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo (Element e) {
        return Long.compare(this.dist, e.dist);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int red1 = sc.nextInt();
        int red2 = sc.nextInt();
        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        long[] dist1 = new long[n+1];
        long[] dist2 = new long[n+1];

        for (int i = 1; i<=n; i++) {
            dist1[i] = (long)1e17;
            dist2[i] = (long)1e17;
        }

        dist1[red1] = 0;
        dist2[red2] = 0;

        pq.add(new Element(0, red1));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minIndex = e.index;
            long minDist = e.dist;

            if (minDist != dist1[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {

                long targetDist = graph[minIndex].get(i).dist;
                int targetIndex = graph[minIndex].get(i).index;

                long newDist = targetDist + dist1[minIndex];
                if (dist1[targetIndex] > newDist) {
                    dist1[targetIndex] = newDist;

                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        pq.add(new Element(0, red2));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minIndex = e.index;
            long minDist = e.dist;

            if (minDist != dist2[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {

                long targetDist = graph[minIndex].get(i).dist;
                int targetIndex = graph[minIndex].get(i).index;

                long newDist = targetDist + dist2[minIndex];
                if (dist2[targetIndex] > newDist) {
                    dist2[targetIndex] = newDist;

                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        long min = (long)1e17;

        for (int i = 1; i<=n; i++) {
            if (i == red1 || i == red2) {
                continue;
            }

            min = Math.min(min, dist1[i] + dist2[i] + dist1[red2]);
        }

        if (min == (long)1e17) {
            System.out.print(-1);
        }

        else {
            System.out.print(min);
        }
        
    }
}