import java.util.*;

class Node {
    int index;
    int dist;

    public Node (int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
}

class Element implements Comparable<Element> {

    int dist;
    int index;

    public Element (int dist, int index) {
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo (Element e) {
        return this.dist - e.dist;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (int)1e9;
        }

        dist[k] = 0;

        pq.add(new Element(0, k));

        while (!pq.isEmpty()) {
            Element e = pq.poll();
            int minDist = e.dist;
            int minIndex = e.index;

            if (minDist != dist[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {

                Node node = graph[minIndex].get(i);

                int newDist = dist[minIndex] + node.dist;

                if (dist[node.index] > newDist) {
                    dist[node.index] = newDist;
                    pq.add(new Element(newDist, node.index));
                }
            }
        }

        for (int i = 1; i<=n; i++) {
            if (dist[i] == (int)1e9) {
                System.out.println(-1);
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }
}