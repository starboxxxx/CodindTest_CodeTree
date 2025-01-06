import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String o = sc.next();
        int c = sc.nextInt();

        if (o.charAt(0) == '+') {
            System.out.printf("%d + %d = %d", a, c, plus(a, c));
        }
        else if(o.charAt(0) == '-') {
            System.out.printf("%d - %d = %d", a, c, minus(a, c));
        }
        else if (o.charAt(0) == '*') {
            System.out.printf("%d * %d = %d", a, c, time(a, c));
        }
        else if (o.charAt(0) == '/') {
            System.out.printf("%d / %d = %d", a, c, divide(a, c));
        }
        else {
            System.out.print("False");
        }
    }

    public static int plus(int a, int c) {
        return a + c;
    }

    public static int minus(int a, int c) {
        return a - c;
    }

    public static int time(int a, int c) {
        return a * c;
    }
    
    public static int divide(int a, int c) {
        return a / c;
    }
}