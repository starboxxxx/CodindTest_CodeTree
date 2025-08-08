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

    public static int n;
    public static int m;
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static long[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<Node>[] graphA = new ArrayList[n+1];
        ArrayList<Node>[] graphB = new ArrayList[n+1];

        for (int i = 1; i<=n; i++) {
            graphA[i] = new ArrayList<>();
            graphB[i] = new ArrayList<>();
        }

        for (int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long distA = sc.nextLong();
            long distB = sc.nextLong();

            graphA[a].add(new Node(b, distA));
            graphB[a].add(new Node(b, distB));
        }

        dist = new long[n+1];

        ArrayList<Integer> listA = da(graphA);

        ArrayList<Integer> listB = da(graphB);

        int countA = 0;
        for (int p = listA.size()-1; p>=1; p--) {
            int current = listA.get(p);
            int next = listA.get(p-1);

            long original = 0;

            long min = 100000;
            for (int i = 0; i<graphB[current].size(); i++) {
                long dist = graphB[current].get(i).dist;
                int targetIndex = graphB[current].get(i).index;

                if (targetIndex == next) {
                    original = dist;
                }

                min = Math.min(min, dist);
            }

            if (min != original) {
                countA++;
            }
        }

        int countB = 0;
        for (int p = listB.size()-1; p>=1; p--) {
            int current = listB.get(p);
            int next = listB.get(p-1);

            long original = 0;

            long min = 100000;
            for (int i = 0; i<graphA[current].size(); i++) {
                long dist = graphA[current].get(i).dist;
                int targetIndex = graphA[current].get(i).index;

                if (targetIndex == next) {
                    original = dist;
                }

                min = Math.min(min, dist);
            }

            if (min != original) {
                countB++;
            }
        }



        System.out.print(Math.min(countA, countB));

    }

    public static ArrayList<Integer> da(ArrayList<Node>[] graph) {
        
        for (int i = 1; i<=n; i++) {
            dist[i] = (long)1e17;
        }

        dist[1] = 0;

        pq.add(new Element(0, 1));

        int[] answer = new int[n+1];

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

                long newDist = dist[minIndex] + targetDist;

                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;

                    answer[targetIndex] = minIndex;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        int x = n;

        list.add(x);

        while (x != 1) {
            x = answer[x];
            list.add(x);
        }

        return list;
    }
}