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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int dist = sc.nextInt();

            graph[s].add(new Node(e, dist));
            graph[e].add(new Node(s, dist));
        }

        int dist[] = new int[n+1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for (int i = 1; i<=n; i++) {

            for (int j = 1; j<=n; j++) {
                dist[j] = (int)1e9;
            }
            dist[i] = 0;

            pq.add(new Element(0, i));

            int min = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                Element e = pq.poll();

                int minIndex = e.index;
                int minDist = e.dist;

                if (dist[minIndex] != minDist) {
                    continue;
                }

                for (int j = 0; j<graph[minIndex].size(); j++) {
                    int index = graph[minIndex].get(j).index;
                    int distance = graph[minIndex].get(j).dist;

                    int newDist = dist[minIndex] + distance;

                    if (dist[index] > newDist) {
                        dist[index] = newDist;
                        pq.add(new Element(newDist, index));

                        if (index == a || index == b || index == c) {
                            min = Math.min(min, newDist);
                        }
                    }
                }
            }

            max = Math.max(max, min);
        }
        
        System.out.print(max);
    }
}