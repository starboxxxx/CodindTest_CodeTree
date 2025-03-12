import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++){
            bombs[i] = sc.nextInt();
        }
        int max = 0;
        int answer = 0;
        for(int j = 0; j<n-1; j++) {
            int current = j;
            int count = 0;
            for (int z = j+1; z<n; z++) {
                if (bombs[z] == bombs[j] && z - current <= k) {
                    count++;
                    current = z;
                }
            }

            if (count > max && bombs[j] > answer) {
                max = count;
                answer = bombs[j];
            }
        }

        System.out.print(answer);
    }
}