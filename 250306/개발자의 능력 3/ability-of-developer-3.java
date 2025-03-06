import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];
        int total = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<6; i++) {
            for (int j = i+1; j<6; j++) {
                for (int z = j+1; z<6; z++) {
                    int sum2 = 0;
                    int sum1 = 0;
                    sum2 += ability[i];
                    sum2 += ability[j];
                    sum2 += ability[z];

                    sum1 = total - sum2;
                    if (Math.abs(sum2 - sum1) < min) {
                        min = Math.abs(sum2 - sum1);
                    }
                }
            }
        }

        System.out.print(min);
    }
}