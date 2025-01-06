import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();

        System.out.print(check(y));
    }

    public static boolean check(int y) {
        if (y % 4 == 0) {
            if (y % 100 == 0 && y % 400 != 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}