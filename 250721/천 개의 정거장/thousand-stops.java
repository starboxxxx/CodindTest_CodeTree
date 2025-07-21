import java.util.*;

class Pair {
    long cost;
    long time;

    public Pair(long cost, long time) {
        this.cost = cost;
        this.time = time;
    }

    public boolean isGreaterThan(Pair p) {
        return this.cost > p.cost || (this.cost == p.cost && this.time > p.time);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        
        Pair[][] graph = new Pair[1001][1001];

        for (int i = 1; i<=1000; i++) {
            for (int j = 1; j<=1000; j++) {
                graph[i][j] = new Pair((long)1e17 + 1, 0);
            }
            graph[i][i] = new Pair(0, 0);
        }

        for (int i = 1; i<=n; i++) {
            int cost = sc.nextInt();
            int stopNum = sc.nextInt();

            ArrayList<Integer> stops = new ArrayList<>();

            for (int j = 0; j<stopNum; j++) {
                int x = sc.nextInt();
                stops.add(x);
            }

            for (int j = 0; j<stopNum; j++) {
                for (int k = j+1; k<stopNum; k++) {
                    Pair newP = new Pair(cost, k-j);

                    if (graph[stops.get(j)][stops.get(k)].isGreaterThan(newP)) {
                        graph[stops.get(j)][stops.get(k)] = newP;
                    }
                }
            }
        }

        Pair[] dist = new Pair[1001];

        for (int i = 1; i<=1000; i++) {
            dist[i] = new Pair((long)1e17 + 1, 0);
        }

        dist[a] = new Pair(0, 0);

        int[] visited = new int[1001];
        

        for (int i = 1; i<=1000; i++) {
            int minIndex = -1;

            for (int j = 1; j<=1000; j++) {
                if (visited[j] == 1) {
                    continue;
                }

                if (minIndex == -1 || dist[minIndex].isGreaterThan(dist[j])) {
                    minIndex = j;
                }
            }

            visited[minIndex] = 1;

            long minCost = dist[minIndex].cost;
            long minTime = dist[minIndex].time;

            for (int j = 1; j<=1000; j++) {
                long cost = graph[minIndex][j].cost;
                long time = graph[minIndex][j].time;

                Pair newP = new Pair(minCost + cost, minTime + time);

                if (dist[j].isGreaterThan(newP)) {
                    dist[j] = newP;
                }
            }
        }

        if (dist[b].cost == (long)1e17+1) {
            dist[b] = new Pair(-1, -1);
        }

        long minCost = dist[b].cost;
        long minTime = dist[b].time;

        System.out.print(minCost + " " + minTime);
    }
}