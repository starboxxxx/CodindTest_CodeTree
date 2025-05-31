import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        TreeSet<Character> set = new TreeSet<>();
        int n = s.length();

        char[] input = s.toCharArray();

        int j = 0;
        set.add(input[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            while (j+1 < n && !set.contains(input[j+1])) {
                set.add(input[j+1]);
                j++;
            } 

            max = Math.max(max, set.size());
            set.remove(input[i]);
        }

        System.out.print(max);
    }
}