import java.util.*;

class Key {
    int a;
    int b;
    long dist;

    public Key (int a, int b, long dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}

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
    public int compareTo(Element e) {
        return Long.compare(this.dist, e.dist);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Key> keys = new ArrayList<>();

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        keys.add(new Key(0, 0, 0));

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();

            keys.add(new Key(u, v, w));

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        long[] dist = new long[n+1];

        long original = 0;
        long max = 0;

        for (int i = 0; i<keys.size(); i++) {
            Key key = keys.get(i);

            int a = key.a;
            int b = key.b;

            for (int j = 1; j<=n; j++) {
                dist[j] = (long)1e17;
            }

            dist[1] = 0;

            pq.add(new Element(0, 1));

            while (!pq.isEmpty()) {
                Element e = pq.poll();
                int minIndex = e.index;
                long minDist = e.dist;
            
                if (minDist != dist[minIndex]) {
                    continue;
                }

                for (int j = 0; j<graph[minIndex].size(); j++) {
                    int targetIndex = graph[minIndex].get(j).index;

                    long targetDist = graph[minIndex].get(j).dist;
                    if ((minIndex == a && targetIndex == b)
                    || (minIndex == b && targetIndex == a)) {
                        targetDist *= 2;
                    }

                    long newDist = targetDist + dist[minIndex];

                    if (dist[targetIndex] > newDist) {
                        dist[targetIndex] = newDist;

                        pq.add(new Element(newDist, targetIndex));
                    }
                }
            }

            if (a == 0 && b == 0) {
                original = dist[n];
            }

            else {
                max = Math.max(max, dist[n]);
            }

        }

        System.out.print(max - original);
    }
}