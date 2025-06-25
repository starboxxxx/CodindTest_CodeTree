import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        int n = first.length();
        int[] del = new int[n];
        for (int i = 0; i < n; i++) {
            del[i] = sc.nextInt()-1;
        }

        int left = 0;
        int right = n-1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            TreeSet<Integer> set = new TreeSet<>();

            for (int i = 0; i<=mid; i++) {
                set.add(del[i]);
            }

            int current = 0;
            int target = 0;

            while (current < first.length() && target < second.length()) {
                if (!set.contains(current)) {
                    if (first.charAt(current) == second.charAt(target)) {
                        target++;
                    }
                }
                current++;
            }

            if (target == second.length()) {
                left = mid+1;
                answer = Math.max(answer, mid+2);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(answer);
        

    }
}