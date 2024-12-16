import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        boolean result = false;

        if (score == 100) {
            result = true;
        }

        if (result) {
            System.out.print("pass");
        }
        else {
            System.out.print("failure");
        }
    }
}