import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        
        for (int i = 1; i<=10000 / (2*n); i++) {
            boolean isTrue = true;
            int num = i;
            for (int j = 0; j<n; j++) {
                num *= 2;
                if (num >= a[j] && num <= b[j]) {
                    continue;
                }
                isTrue = false;
                break;
            }
            if (isTrue) {
                System.out.print(i);
                break;
            }
        }
    }
}