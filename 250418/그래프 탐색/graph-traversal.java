import java.util.*;
public class Main {

    public static int n;
    public static int m;
    public static ArrayList<Integer>[] v;
    public static int[] visited;
    public static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        v = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i = 1; i<=n; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int k = sc.nextInt();

            v[u].add(k);
            v[k].add(u);
        }  
        visited[1] = 1;
        
        Dfs(1);
        System.out.print(count);
    }

    public static void Dfs(int current) {

        for (int i = 0; i<v[current].size(); i++) {
            int target = v[current].get(i);

            if (visited[target] == 0) {
                visited[target] = 1;
                count++;
                Dfs(target);
            }
        }
    }
}