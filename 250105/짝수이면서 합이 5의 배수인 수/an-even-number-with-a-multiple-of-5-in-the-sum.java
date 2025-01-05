import java.util.*;

public class Main {
    public static boolean checkNum(int n) {
        int total = n / 10 + n % 10;
        return n % 2 == 0 && total % 5 == 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (checkNum(n)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}