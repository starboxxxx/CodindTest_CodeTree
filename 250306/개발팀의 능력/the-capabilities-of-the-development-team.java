import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] ability = new int[5];

        int total = 0;

        for (int i = 0; i<5; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        } 

        int[] sum = new int[3];

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i<5; i++) {
            sum[0] = ability[i];
            for (int j = 0; j<5; j++) {
                for (int z = j+1; z<5; z++) {
                    if (j == i || z == i) {
                        continue;
                    }
                    sum[1] = ability[j] + ability[z];

                    sum[2] = total - sum[0] - sum[1];

                    if (sum[0] == sum[1] || sum[1] == sum[2] || sum[2] == sum[0]) {
                        continue;
                    }

                    int max = 0;
                    int min = Integer.MAX_VALUE;

                    for (int x = 0; x<3; x++) {
                        max = Math.max(max, sum[x]);
                        min = Math.min(min, sum[x]);
                    }

                    if (max-min < answer) {
                        answer = max - min;
                    } 
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        }
        else {
            System.out.print(answer);
        }
        
        
    }
}