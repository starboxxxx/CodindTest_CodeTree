import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = 0; j<x; j++) {
                num.add(y);
            }
        }

        Collections.sort(num);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n/2; i++) {
            max = Math.max(max, num.get(i) + num.get(n-i));
        }

        System.out.print(max);
        
    }
}