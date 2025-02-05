import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = new int[200];


        for (int i = 0; i<n; i++) {
            int x1 = sc.nextInt()+100;
            int x2 = sc.nextInt()+100-1;

            for (int j = x1; j<=x2; j++) {
                result[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i<200; i++) {
            if (result[i] > max) {
                max = result[i];
            }    
        }

        System.out.print(max);
    }
}