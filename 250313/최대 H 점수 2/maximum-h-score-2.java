import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        int min = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }


        boolean isTrue = false;
        for (int i = 101; i>= 1; i--) {
            int h = i;
            int count = 0;
            for (int j = 0; j<n; j++) {
                if (count >= l) {
                    break;
                }
                if (a[j] + 1 == h) {
                    a[j]++;
                    count++;
                }
            }

            int c = 0;

            for (int j = 0; j<n; j++) {
                if (a[j] >= h) {
                    c++;
                }

                if (c >= h) {
                    isTrue = true;
                    break;
                }
            }
            if (isTrue) {
                System.out.print(h);
                break;
            }
        }
    }
}