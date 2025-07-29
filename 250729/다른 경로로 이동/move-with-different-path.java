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
    public int compareTo (Element e) {
        return Long.compare(this.dist, e.dist);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] graph = new long[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextInt();

            graph[u][v] = w;
            graph[v][u] = w;
        }

        long[] dist = new long[n+1];
        int[] visited = new int[n+1];
        
        for (int i = 1; i<=n; i++) {
            dist[i] = (long)1e17;
        }

        dist[n] = 0;
        
        for (int i = 1; i<=n; i++) {
            int minIndex = -1;

            for (int j = 1; j<=n; j++) {
                if (visited[j] == 1) {
                    continue;
                }

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = 1;

            for (int j = 1; j<=n; j++) {
                if (graph[minIndex][j] == 0) {
                    continue;
                }

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        if (dist[1] == (long)1e17) {
            System.out.print(-1);
        }

        else {

            int x = 1;

            int[][] solution = new int[n+1][n+1];

            while (x != n) {
                for (int i = 1; i<=n; i++) {
                    if (graph[i][x] == 0) {
                        continue;
                    }

                    if (dist[i] + graph[i][x] == dist[x]) {
                        solution[i][x] = 1;
                        solution[x][i] = 1;

                        x = i;
                        break;
                    }
                }
            }

            for (int i = 1; i<=n; i++) {
                dist[i] = (long)1e17;
                visited[i] = 0;
            }

            dist[n] = 0;

            for (int i = 1; i<=n; i++) {

                int minIndex = -1;

                for (int j = 1; j<=n; j++) {
                    if (visited[j] == 1) {
                        continue;
                    }

                    if (minIndex == -1 || dist[minIndex] > dist[j]) {
                        minIndex = j;
                    }
                }

                visited[minIndex] = 1;

                for (int j = 1; j<=n; j++) {
                    if (graph[minIndex][j] == 0 ||
                    solution[minIndex][j] == 1
                    || solution[j][minIndex] == 1) {
                        continue;
                    }



                    dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
                }
            }

            System.out.print(dist[1]);
        }
    }
}