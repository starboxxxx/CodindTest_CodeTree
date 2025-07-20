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
        int[][] k = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
            k[x][y] = z;
            k[y][x] = z;
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (int)1e9;
        }

        dist[b] = 0;

        pq.add(new Element(0, b));

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

                if (dist[targetIndex] > targetDist + dist[minIndex]) {
                    dist[targetIndex] = targetDist + dist[minIndex];
                    pq.add(new Element(dist[targetIndex], targetIndex));
                }
            }
        }

        System.out.println(dist[a]);
        
        int x = a;
        System.out.print(a + " ");

        while (x != b) {

            for (int i = 1; i<=n; i++) {
                if (k[x][i] == 0) {
                    continue;
                }

                if (dist[i] + k[i][x] == dist[x]) {
                    x = i;
                    break;
                }
            }
            System.out.print(x + " ");
        }

    }
}