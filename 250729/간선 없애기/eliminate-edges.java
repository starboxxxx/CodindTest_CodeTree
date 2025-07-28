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
    public int compareTo(Element e) {
        return Long.compare(this.dist, e.dist);
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
            long w = sc.nextLong();

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }


        PriorityQueue<Element> pq = new PriorityQueue<>();

        long[] dist = new long[n+1];
        int[] solution = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (long)1e17;
        }

        dist[1] = 0;

        pq.add(new Element(0, 1));

        while (!pq.isEmpty()) {
            Element e = pq.poll();

            int minIndex = e.index;
            long minDist = e.dist;

            if (dist[minIndex] != minDist) {
                continue;
            }

            for (int i = 0; i<graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                long targetDist = graph[minIndex].get(i).dist;

                long newDist = targetDist + dist[minIndex];

                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    solution[targetIndex] = minIndex;

                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        long original = dist[n];

        ArrayList<Integer> list = new ArrayList<>();

        list.add(n);

        int idx = n;

        while (idx != 1) {
            idx = solution[idx];
            list.add(idx);
        }

        int count = 0;

        for (int k = 1; k<=list.size()-2; k++) {

            for (int i = 1; i<=n; i++) {
                dist[i] = (long)1e17;
            }

            dist[1] = 0;

            pq.add(new Element(0, 1));

            while (!pq.isEmpty()) {
                Element e = pq.poll();

                int minIndex = e.index;
                long minDist = e.dist;

                if ((dist[minIndex] != minDist) || (minIndex == k)) {
                    continue;
                } 

                for (int i = 0; i<graph[minIndex].size(); i++) {
                    int targetIndex = graph[minIndex].get(i).index;
                    long targetDist = graph[minIndex].get(i).dist;

                    if (targetIndex == k) {
                        continue;
                    }

                    long newDist = targetDist + dist[minIndex];

                    if (dist[targetIndex] > newDist) {
                        dist[targetIndex] = newDist;

                        pq.add(new Element(newDist, targetIndex));
                    }
                }
            }

            if (dist[n] != original) {
                count++;
            }
        }

        System.out.print(count);
        
    }
}