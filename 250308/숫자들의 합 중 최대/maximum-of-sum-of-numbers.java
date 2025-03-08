import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int max = 0;

        for (int i = x; i<=y; i++) {
            String a = String.valueOf(i);
            int total = 0;
            for (int j = 0; j<a.length(); j++) {
                total += a.charAt(j) - '0';
            }
            if (total > max) {
                max = total;
            }
        }

        System.out.print(max);
    }
}