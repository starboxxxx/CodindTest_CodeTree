import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alpha = sc.next();
        char a = alpha.charAt(0);

        if (a == 'S') {
            System.out.print("Superior");
        }
        else if (a == 'A') {
            System.out.print("Excellent");
        }
        else if (a == 'B') {
            System.out.print("Good");
        }
        else if (a == 'C') {
            System.out.print("Usually");
        }
        else {
            System.out.print("Effort");
        }
    }
}