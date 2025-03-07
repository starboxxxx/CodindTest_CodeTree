import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int count = 0;        
        for (int i = 0; i<n; i++) {
            boolean success = true;
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    continue;
                }

                if (x1[j] > x1[i] && x2[j]<x2[i]) {
                    success = false;
                    break;
                }

                if (x1[j] < x1[i] && x2[j] > x2[i]) {
                    success = false;
                    break;
                }
            }
            if (success == true) {
                count++;
            }
        }

        System.out.print(count);
    }
}