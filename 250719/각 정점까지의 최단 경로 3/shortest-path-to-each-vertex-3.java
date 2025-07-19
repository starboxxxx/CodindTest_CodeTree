import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] vertex = new int[n+1][n+1];
        int[] visited = new int[n+1];
        int[] dist = new int[n+1];

        for (int i = 1; i<=n; i++) {
            dist[i] = (int)1e9;
        }
        dist[1] = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            vertex[u][v] = w;
        }


        
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
                if (vertex[minIndex][j] == 0) {
                    continue;
                }

                dist[j] = Math.min(dist[j], dist[minIndex] + vertex[minIndex][j]);
            }
        }

        for (int i = 2; i<=n; i++) {
            if (dist[i] == (int)1e9) {
                System.out.println(-1);
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }
}