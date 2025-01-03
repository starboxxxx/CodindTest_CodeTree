import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.next().charAt(0);

        if (n == 97) {
            n = 122;
        }
        else {
            n--;
        }

        System.out.print((char) n);
    }
}