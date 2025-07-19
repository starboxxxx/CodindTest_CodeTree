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
    public int compareTo(Element e) {
        return this.dist - e.dist;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        } 

        for (int i = 0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();
            graph[x].add(new Node(y, v));
            graph[y].add(new Node(x, v));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = 10000;
        }

        dist[n] = 0;

        pq.add(new Element(0, n));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minDist = e.dist;
            int minIndex = e.index;

            if (minDist != dist[minIndex]) {
                continue;
            }

            for (int j = 0; j<graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                int distance = dist[minIndex] + targetDist;

                if (dist[targetIndex] > distance) {
                    dist[targetIndex] = distance;
                    pq.add(new Element(distance, targetIndex));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i<n; i++) {
            max = Math.max(max, dist[i]);
        }

        System.out.print(max);
    }
}