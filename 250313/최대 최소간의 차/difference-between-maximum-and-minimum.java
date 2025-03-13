import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i<=9999; i++) {
            for (int j = i+1; j<=i+k; j++) {
                if (j<= 10000) {
                    int cost = 0;
                    for (int z = 0; z<n; z++) {
                        cost += Math.min(Math.abs(arr[z] - i), Math.abs(arr[z] - j));
                    }
                    if (cost < min) {
                        min = cost;
                    }
                }
            }
        }

        System.out.print(min);
    }
}