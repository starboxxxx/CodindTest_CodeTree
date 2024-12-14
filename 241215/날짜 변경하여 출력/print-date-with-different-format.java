import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\\.");

        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        System.out.printf("%d-%d-%d", month, day, year);
    }
}