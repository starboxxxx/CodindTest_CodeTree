import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] alpha = new char[100000];
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);

            alpha[pos] = c;
        }

        int max = 0;
        int total = 0;
        int result = 0;
        
        for (int i = 1; i<alpha.length-k; i++) {
            for (int j = i; j<=i+k; j++) {
                if (alpha[j] == 'G') {
                    total++;
                }
                else if (alpha[j] == 'H'){
                    total += 2;
                }
            }

            if (total > max) {
                max = total;
            }
            total = 0;
        }

        System.out.print(max);
    }
}