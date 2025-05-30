import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] count = new int[100001];
        int num = arr[0];
        count[num]++;
        int index = 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i<n; i++) {
            
            while (index+1 < n && count[arr[index+1]] != 1) {
                count[arr[index+1]] = 1;
                index++;
            }

            max = Math.max(max, index-i+1);
            count[arr[i]]--;
        }

        System.out.print(max);


    }
}