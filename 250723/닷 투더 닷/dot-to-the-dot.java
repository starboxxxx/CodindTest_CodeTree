import java.util.*;

class Node {
    int index, L, C;
    public Node(int index, int L, int C) {
        this.index = index;
        this.L = L;
        this.C = C;
    }
}

class State implements Comparable<State> {
    int index, dist, minC, time;

    public State(int index, int dist, int minC) {
        this.index = index;
        this.dist = dist;
        this.minC = minC;
        this.time = dist + Main.x / minC;
    }

    public int compareTo(State o) {
        return this.time - o.time;
    }
}

public class Main {
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        x = sc.nextInt();

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), l = sc.nextInt(), c = sc.nextInt();
            graph[a].add(new Node(b, l, c));
            graph[b].add(new Node(a, l, c));
        }

        Map<Integer, Integer>[] time = new HashMap[n + 1];
        for (int i = 1; i <= n; i++) time[i] = new HashMap<>();

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0, 1_000_000));
        time[1].put(1_000_000, 0);

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curTime = cur.time;
            if (time[cur.index].getOrDefault(cur.minC, Integer.MAX_VALUE) < curTime) continue;

            for (Node next : graph[cur.index]) {
                int newDist = cur.dist + next.L;
                int newMinC = Math.min(cur.minC, next.C);
                int newTime = newDist + x / newMinC;

                if (time[next.index].getOrDefault(newMinC, Integer.MAX_VALUE) > newTime) {
                    time[next.index].put(newMinC, newTime);
                    pq.add(new State(next.index, newDist, newMinC));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int t : time[n].values()) ans = Math.min(ans, t);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}