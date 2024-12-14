import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char alpha = sc.next().charAt(0);
        Double a = sc.nextDouble();
        Double b =  sc.nextDouble();

        System.out.printf("%c\n%.2f\n%.2f", alpha, a, b);
    }
}