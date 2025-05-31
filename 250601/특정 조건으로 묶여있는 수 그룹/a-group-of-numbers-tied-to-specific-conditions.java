import java.util.*;

class Number implements Comparable<Number> {
    int index;
    int x;

    public Number(int index, int x) {
        this.index = index;
        this.x = x;
    }

    @Override
    public int compareTo(Number n) {
        if (this.x != n.x) {
            return this.x - n.x;
        }
        return this.index - n.index;
    }
}

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static TreeSet<Number> group1 = new TreeSet<>();
    public static TreeSet<Number> group2 = new TreeSet<>();
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

        group1.add(new Number(0, arr[0]));
        int j = 0;

        for (int i = 0; i<n; i++) {
            while (j+1 < n && can(j+1)) {
                put(j+1);
                j++;
            }

            if (group1.size() + group2.size() >= max) {
                max = Math.max(max, group1.size() + group2.size());
            }

            if (group1.contains(new Number(i, arr[i]))) {
                group1.remove(new Number(i, arr[i]));
            }

            else if (group2.contains(new Number(i, arr[i]))) {
                group2.remove(new Number(i, arr[i]));
            }
        }
        System.out.print(max);
    }

    public static boolean can (int j) {
        if (group1.isEmpty() || group2.isEmpty() || arr[j] - group1.first().x <= k || arr[j] - group2.first().x <= k) {
            return true;
        }
        return false;
    }

    public static void put (int j) {
        if (group1.isEmpty() || arr[j] - group1.first().x <= k) {
            group1.add(new Number(j, arr[j]));
        }

        else if (group2.isEmpty() || arr[j] - group2.first().x <= k) {
            group2.add(new Number(j, arr[j]));
        }
    }
}