import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int c = 0;
        
        for (int i = x; i<=y; i++) {
            String num = String.valueOf(i);
            int[] count = new int[10];
            for (int j = 0; j<num.length(); j++) {
                int n = num.charAt(j) - '0';
                count[n]++;
            }

            for (int j = 0; j<10; j++) {
                if (count[j] == num.length()-1) {
                    c++;
                }
            }
        }

        System.out.print(c);
    }
}