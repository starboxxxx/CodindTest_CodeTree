import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num = new int[n];

        int max = 0;
        for (int i = 0; i<n; i++) {
            num[i] = sc.nextInt();
            max = Math.max(max, num[i]);
        }
        
        for (int i = max; i<Integer.MAX_VALUE; i++) {
            int k = i;
            int sum = 0;
            int count = 0;
            boolean isTrue = true;
            for (int j = 0; j<n; j++) {
                if (num[j] + sum > k) {
                    if (j==n-1) {
                        count += 2;
                    }
                    else {
                        count++;
                        sum = num[j];
                    }
                }
                else if (num[j] + sum == k) {
                    count++;
                    sum = 0;
                }
                else {

                    if (j == n-1) {
                        count++;
                    }
                    else {
                        sum += num[j];
                    }
                }
            }
            if (count == m && isTrue) {
                System.out.print(k);
                break;
            }
        }
    }
}