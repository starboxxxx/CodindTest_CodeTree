import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        char[] k = new char[A.length()];

        for (int i = 0; i<A.length(); i++) {
            k[i] = A.charAt(i);
        }

        int[] sum = new int[A.length()];

        for (int i = A.length()-2; i>=0; i--) {
            sum[i] = sum[i+1];
            if (k[i] == ')' && k[i+1] == ')') {
                sum[i]++;
            }
        }

        long total = 0;

        for (int i = 1; i<A.length(); i++) {
            
            if (k[i] == '(' && k[i-1] == '(') {
                total += (long)sum[i];
            }
        }

        System.out.print(total);
    }
}