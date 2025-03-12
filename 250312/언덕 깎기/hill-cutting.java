import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i<=100; i++) {
            int cost = 0;

            for (int j = 0; j<n; j++) {
                if (arr[j] < i) {
                    cost += (arr[j] - i) * (arr[j] - i);
                }

                if (arr[j] > i + 17) {
                    cost += (arr[j] - (i + 17)) * (arr[j] - (i + 17));
                }
            }

            if (cost < answer) {
                answer = cost;
            }
        }

        System.out.print(answer);
    }
}