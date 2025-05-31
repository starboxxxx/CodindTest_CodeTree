import java.util.*;

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static TreeSet<Integer> group1 = new TreeSet<>();
    public static TreeSet<Integer> group2 = new TreeSet<>();
    public static int[] arr;
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Arrays.sort(arr);

        group1.add(0);
        int j = 0;

        for (int i = 0; i<n; i++) {
            while (j+1 < n && can(j+1)) {
                put(j+1);
                j++;
            }

            if (group1.contains(i)) {
                group1.remove(i);
            }

            else if (group2.contains(i)) {
                group2.remove(i);
            }
        }
        System.out.print(max);
    }

    public static boolean can (int j) {
        if (group1.isEmpty() || group2.isEmpty() || arr[j] - arr[group1.first()] <= k || arr[j] - arr[group2.first()] <= k) {
            return true;
        }
        return false;
    }

    public static void put (int j) {
        if (group1.isEmpty() || arr[j] - arr[group1.first()] <= k) {
            group1.add(j);
        }

        else if (group2.isEmpty() || arr[j] - arr[group2.first()] <= k) {
            group2.add(j);
        }

        max = Math.max(max, group1.size() + group2.size());
    }
}