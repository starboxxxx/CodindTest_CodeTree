import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = Integer.MAX_VALUE;
        int index = -1;
        int sum = 0;

        for (int i = 0; i<n; i++) {

            while (index + 1 < n && sum + arr[index+1] < s) {
                sum += arr[index+1];
                index++;
            }
            
            if (index != n-1) {
                answer  = Math.min(answer, index+1 - i + 1);
            }

            sum -= arr[i];
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else {
            System.out.print(answer);
        }
    }
}