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

        int[] result = new int[n+1];
        for (int i = 1; i<=n; i++) {
            result[i] = (int)1e9;
        }

        int dist[] = new int[n+1];
        int[] num = new int[]{a, b, c};
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (int i = 0; i<=2; i++) {
            
            int p = num[i];
            for (int j = 1; j<=n; j++) {
                dist[j] = (int)1e9;
            }
            dist[p] = 0;

            pq.add(new Element(0, p));

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
                    }
                }
            }

            for (int j = 1; j<=n; j++) {
                result[j] = Math.min(result[j], dist[j]);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i<=n; i++) {
            if (i == a || i == b || i == c) {
                continue;
            }
            max = Math.max(max, result[i]);
        }
        
        System.out.print(max);
    }
}