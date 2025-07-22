import java.util.*;

class Node {
    int x;
    int y;
    int time;

    public Node (int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Element implements Comparable<Element> {

    int x;
    int y;
    int time;

    public Element(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo (Element e) {
        return this.time - e.time;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] brackets = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                brackets[i][j] = row.charAt(j);
            }
        }

        ArrayList<Node>[][] graph = new ArrayList[n][n];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {

                int x = i;
                int y = j;

                char original = brackets[x][y];

                for (int k = 0; k<4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                        if (brackets[newX][newY] == original) {
                            graph[x][y].add(new Node(newX, newY, a));
                        }
                        else {
                            graph[x][y].add(new Node(newX, newY, b));
                        }
                    }
                }
            }
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        long[][] distance = new long[n][n];

        long max = Long.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {

                for (int p = 0; p<n; p++) {
                    for (int q = 0; q<n; q++) {
                        distance[p][q] = (long)1e17 + 1;
                    }
                }

                distance[i][j] = 0;
                pq.add(new Element(i, j, 0));

                while (!pq.isEmpty()) {
                    Element e = pq.poll();

                    int x = e.x;
                    int y = e.y;
                    int time = e.time;

                    if (time != distance[x][y]) {
                        continue;
                    }

                    for (int k = 0; k<graph[x][y].size(); k++) {
                        int targetX = graph[x][y].get(k).x;
                        int targetY = graph[x][y].get(k).y;
                        int targetTime = graph[x][y].get(k).time;

                        int newTime = time + targetTime;

                        if (distance[targetX][targetY] > newTime) {
                            distance[targetX][targetY] = newTime;
                            pq.add(new Element(targetX, targetY, newTime));
                        }
                    }
                }

                for (int p = 0; p<n; p++) {
                    for (int q = 0; q<n; q++) {
                        max = Math.max(max, distance[p][q]);
                    }
                }
            }
        }

        System.out.print(max);
    }
}