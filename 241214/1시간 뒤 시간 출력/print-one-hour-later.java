import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(":");
        int hour = sc.nextInt();
        int min = sc.nextInt();

        System.out.printf("%d:%d", hour + 1, min);
    }
}