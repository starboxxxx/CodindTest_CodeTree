import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {
            min = Math.min(min, ta[i]);
            max = Math.max(max, tb[i]);
        }


        int maxWork = 0;
        for (int i = min; i<=max; i++) {
            int work = 0;
            for (int j = 0; j<n; j++) {
                if (i < ta[j]) {
                    work += c;
                }
                else if (i >= ta[j] && i <= tb[j]) {
                    work += g;
                }
                else {
                    work += h;
                }
            }
            if (work > maxWork) {
                maxWork = work;
            }
        }

        System.out.print(maxWork);
    }
}