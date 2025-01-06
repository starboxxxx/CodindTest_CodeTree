import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        count(a, b);
    }

    public static void count(int a, int b) {
        int count = 0;
        for (int i = a; i<=b; i++) {
            if (i % 3 == 0) {
                count++;
            }
            else {
                String input = String.valueOf(i);
                for (int j = 0; j<input.length(); j++) {
                    if (input.charAt(j) == '3' || input.charAt(j) == '6'
                    || input.charAt(j) == '9') {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
}