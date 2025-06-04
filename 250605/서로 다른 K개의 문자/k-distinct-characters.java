import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.next();
        int k = sc.nextInt();

        int n = message.length();

        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] m = message.toCharArray();
        map.put(m[0], 1);

        int j = 0;
        int answer = 1;
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            while (j+1 < n) {

                if (map.containsKey(m[j+1])) {
                    int x = map.get(m[j+1]);
                    map.put(m[j+1], x+1);
                }
                else {
                    if (cnt == k) {
                        break;
                    }
                    map.put(m[j+1], 1);
                    cnt++;
                }

                answer++;
                j++;
            }

            max = Math.max(max, answer);
            int p = map.get(m[i]);
            if (p == 1) {
                map.remove(m[i]);
                cnt--;
            }
            else {
                map.put(m[i], p-1);
            }

            answer--;
        }

        System.out.print(max);
    }
}