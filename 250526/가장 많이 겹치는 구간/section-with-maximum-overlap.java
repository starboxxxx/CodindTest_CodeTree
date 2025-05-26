import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[200001];
        for (int i = 0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            num[a]++;
            num[b]--;
        }


        for (int i = 1; i<=200000; i++) {
            num[i] += num[i-1];
        }

        int max= Integer.MIN_VALUE;
        for (int i = 1; i<=200000; i++) {
            max = Math.max(max, num[i]);
        }

        System.out.print(max);
    }
}