import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int month = sc.nextInt();
        int day = sc.nextInt();
        int year = sc.nextInt();

        System.out.printf("%d.%d.%d", year, month, day);
    }
}