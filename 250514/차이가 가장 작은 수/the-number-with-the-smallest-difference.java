import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i<n; i++) {
            int num = arr[i];
            for (int j = i+1; j<n; j++) {
                int k = arr[j];

                if (!set.contains(Math.abs(num-k))) {
                    set.add(Math.abs(num-k));
                }
            }
        }

        System.out.print(set.ceiling(m));
    }
}