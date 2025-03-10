import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[11];
        int[] y = new int[11];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            x[a]++;
            y[b]++;
        }

        Integer[] result = new Integer[21];

        for (int i = 0; i<11; i++) {
            result[i] = x[i];
            result[10+i] = y[i];
        }

        Arrays.sort(result, Collections.reverseOrder());

        if (result[0] + result[1] + result[2] >= 6) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }


    }
}