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
        
        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (int)1e9;
        }

        dist[n] = 0;

        pq.add(new Element(0, n));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minIndex = e.index;
            int minDist = e.dist;

            if (dist[minIndex] != minDist) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = targetDist + dist[minIndex];

                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;

                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i<n; i++) {
            if (dist[i] == (int)1e9) {
                continue;
            }
            max = Math.max(max, dist[i]);
        }

        System.out.print(max);
    }
}