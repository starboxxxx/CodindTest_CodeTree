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
        
        for (int i = max; i<10000000; i++) {
            int k = i;
            int sum = 0;
            int count = 0;
            for (int j = 0; j<n; j++) {
                if (j == n-1) {
                    if (sum + num[j] > k) {
                        count += 2;
                    }
                    else {
                        count++;
                    }
                }

                else {
                    if (sum + num[j] > k) {
                        count++;
                        sum = num[j];
                    }
                    else if (sum + num[j] == k) {
                        count++;
                        sum = 0;
                    }
                    else {
                        sum += num[j];
                    }
                }
            }
            if (count <= m) {
                System.out.print(k);
                break;
            }
        }
    }
}