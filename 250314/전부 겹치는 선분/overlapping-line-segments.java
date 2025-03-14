import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        
        for (int i = 0; i<n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        int start = x1[0];
        int end = x2[0];

        boolean isTrue = true;
        for (int i = 1; i<n; i++) {

            if (x1[i] > end || x2[i] < start) {
                System.out.print("No");
                isTrue = false;
                break;
            }

            else {
                start = Math.max(start, x1[i]);
                end = Math.min(end, x2[i]);
            }
        }

        if (isTrue) {
            System.out.print("Yes");
        }
    }
}