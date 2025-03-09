import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            max = Math.max(max, h[i]);
            min = Math.min(min, h[i]);
        }

        int answer = 1;
        int current = 0;

        int a = -1;

        for (int i = min + 1; i<= max - 1; i++) {
            int count = 0;
            
            for (int j = 0; j<n; j++) {
                if (j <= a) {
                    continue;
                }
                if (h[j] - i > 0) {
                    for (int k = j + 1; k<n; k++) {
                        if (h[k] - i <= 0) {
                            a = k;
                            break;
                        }
                        
                        if (k == n-1) {
                            a = k;
                        }
                    }
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.print(answer);

    }
}