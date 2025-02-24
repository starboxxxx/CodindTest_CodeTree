import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int current;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {
            int count=0;
            for (int j = 0; j<n; j++) {
                current = i+j;
                if (current > n-1) {
                    current = current % n;
                }

                count += (arr[current] * j);
            }
            if (count < minCount) {
                minCount = count;
            }
        }

        System.out.print(minCount);
    }
}