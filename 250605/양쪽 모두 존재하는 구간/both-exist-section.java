import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        // 구간 내부 숫자들
        TreeMap<Integer, Integer> map1 = new TreeMap<>();

        //구간 외부 숫자들
        TreeMap<Integer, Integer> map2 = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            if (num >= 1 && num <= m) {
                if (map2.containsKey(num)) {
                    map2.put(num, map2.get(num)+1);
                }
                else {
                    map2.put(num, 1);
                }
            }
        }

        boolean can = true;

        if (map2.size() != m) {
            can = false;
        }
        else {
            for (int i = 1; i<=m; i++) {
                if (map2.containsKey(i)) {
                    int k = map2.get(i);
                    if (k < 2) {
                        can = false;
                        break;
                    }
                }
                else {
                    can = false;
                    break;
                }
            }
        }

        if (can == false) {
            System.out.print(-1);
        }
        else {
            
            if (map2.containsKey(arr[0])) {
                map2.put(arr[0], map2.get(arr[0])-1);
                map1.put(arr[0], 1);
            }
            

            int j = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i<n; i++) {
                while (j+1 < n) {
                    if (map2.containsKey(arr[j+1])) {
                        if (map2.get(arr[j+1]) == 1) {
                            break;
                        }

                        map2.put(arr[j+1], map2.get(arr[j+1])-1);
                        if (map1.containsKey(arr[j+1])) {
                            map1.put(arr[j+1], map1.get(arr[j+1])+1);
                        }
                        else {
                            map1.put(arr[j+1], 1);
                        }
                    }

                    j++;

                    if (map1.size() == m) {
                        min = Math.min(min, j-i+1);
                    }
                }

                if (map1.containsKey(arr[i])) {
                    int q = map1.get(arr[i]);

                    if (q == 1) {
                        map1.remove(arr[i]);
                    }
                    else {
                        map1.put(arr[i], q-1);
                    }

                    map2.put(arr[i], map2.get(arr[i]) + 1);
                }
            }

            System.out.print(min);
        }
    }
}