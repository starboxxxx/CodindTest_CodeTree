import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(arr[0], 1);

        int j = 0;
        int answer = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            while (j+1 < n) {

                if (map.containsKey(arr[j+1])) {
                    if (map.get(arr[j+1]) == k) {
                        break;
                    }

                    int x = map.get(arr[j+1]);
                    map.put(arr[j+1], x+1);
                }
                else {
                    map.put(arr[j+1], 1);
                }

                answer++;
                j++;
            }
            
            max = Math.max(max, answer);
            map.put(arr[i], map.get(arr[i])-1);
            answer--;
        }

        System.out.print(max);
    }
}