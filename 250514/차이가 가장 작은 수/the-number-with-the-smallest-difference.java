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
            set.add(arr[i]);
        }

        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i<n; i++) {
            int x = arr[i];

            //r-x >= m
            if (set.ceiling(m+x) != null) {
                answer = Math.min(answer, set.ceiling(m+x)-x);
            }

            //x - r >=m
            if (set.floor(x-m) != null) {
                answer = Math.min(answer, x-set.floor(x-m));
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else {
            System.out.print(answer);
        }
    }
}