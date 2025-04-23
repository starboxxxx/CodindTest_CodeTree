import java.util.Scanner;
public class Main {

    public static int n;
    public static int[] arr;
    public static int[] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            count[i] = 1;
        }
        
        System.out.print(dp());
    }

    public static int dp() {
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<i; j++) {
                if (arr[j] > arr[i]) {
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}