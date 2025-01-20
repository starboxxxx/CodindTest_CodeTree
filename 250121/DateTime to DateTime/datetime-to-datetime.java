import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int total1 = 11 * 24 * 60 + 60 * 11 + 11;
        int total2 = a * 24 * 60 + 60 * b + c;

        System.out.print(total2 - total1); 
    }
}