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

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] dist = new int[n+1];
        int[] answer = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (int)1e9;
        }

        dist[a] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>();

        pq.add(new Element(0, a));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minDist = e.dist;
            int minIndex = e.index;

            if (minDist != dist[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int distance = dist[minIndex] + targetDist;

                if (dist[targetIndex] > distance) {
                    dist[targetIndex] = distance;
                    pq.add(new Element(distance, targetIndex));
                    answer[targetIndex] = minIndex;
                } 
            }
        }

        System.out.println(dist[b]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(b);
        int x = b;
        while (x != a) {
            x = answer[x];
            list.add(x);
        }

        for (int i = list.size()-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }

    }
}