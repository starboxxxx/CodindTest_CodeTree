import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] ability = new int[6];

        int total = 0;

        for (int i = 0; i<6; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        } 

        int[] sum = new int[3];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i<6; i++) {
            for (int j = i+1; j<6; j++) {
                sum[0] = ability[i] + ability[j];

                for (int a = 0; a<6; a++) {
                    for (int b = 0; b<6; b++) {
                        if (a == i || a == j || b == i || b== j) {
                            break;
                        }
                        sum[1] = ability[a] + ability[b];

                        sum[2] = total - sum[0] - sum[1];

                        int max = 0;
                        int min = Integer.MAX_VALUE;
                        for (int x = 0; x<3; x++) {
                            max = Math.max(max, sum[x]);
                            min = Math.min(min, sum[x]);
                        }

                        if (max - min < answer) {
                            answer = max - min;
                        }
                    }
                }
            }
        }

        System.out.print(answer);
        
        
    }
}