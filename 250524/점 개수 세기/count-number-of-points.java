import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[100002];
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
            set.add(points[i]);
        }
        
        int cnt = 1;
        for (Integer num : set) {
            map.put(num, cnt++);
        }

        for (int i = 0; i<N; i++) {

            int num = map.get(points[i]);

            prefixSum[num]++;
        }

        for (int i = 1; i<cnt; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int x;
            if (set.ceiling(a) != null) {
                x = map.get(set.ceiling(a));
            }
            else {
                x = set.size()+1;
            }

            int y;

            if (set.floor(b) != null) {
                y = map.get(set.floor(b));
            }
            else {
                y = 0;
            }

            int answer = prefixSum[y] - prefixSum[x-1];

            System.out.println(answer);
        }
        
        
    }
}