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
        int x = sc.nextInt();

        ArrayList<Node>[] graph1 = new ArrayList[n+1];
        ArrayList<Node>[] graph2 = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graph1[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();

            graph1[start].add(new Node(end, distance));
            graph2[end].add(new Node(start, distance));
        }

        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist1[i] = (int)1e9;
            dist2[i] = (int)1e9;
        }

        dist1[x] = 0;
        dist2[x] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>();

        pq.add(new Element(0, x));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minDist = e.dist;
            int minIndex = e.index;

            if (minDist != dist1[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph1[minIndex].size(); i++) {
                int targetIndex = graph1[minIndex].get(i).index;
                int targetDist = graph1[minIndex].get(i).dist;

                if (dist1[targetIndex] > dist1[minIndex] + targetDist) {
                    dist1[targetIndex] = dist1[minIndex] + targetDist;
                    pq.add(new Element(dist1[minIndex] + targetDist, targetIndex));
                }
            }
        }

        pq.add(new Element(0, x));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minDist = e.dist;
            int minIndex = e.index;

            if (minDist != dist2[minIndex]) {
                continue;
            }

            for (int i = 0; i<graph2[minIndex].size(); i++) {
                int targetIndex = graph2[minIndex].get(i).index;
                int targetDist = graph2[minIndex].get(i).dist;

                if (dist2[targetIndex] > dist2[minIndex] + targetDist) {
                    dist2[targetIndex] = dist2[minIndex] + targetDist;
                    pq.add(new Element(dist2[minIndex] + targetDist, targetIndex));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i<=n; i++) {
            max = Math.max(max, dist1[i] + dist2[i]);
        }

        System.out.print(max);

    }
}