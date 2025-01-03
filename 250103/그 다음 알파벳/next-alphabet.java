import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = (int) sc.next().charAt(0);
        if (n == 122) {
            n = 97;
        }
        else {
            n++;
        }
        System.out.print((char) n);
    }
}