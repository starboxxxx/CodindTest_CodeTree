import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        int start = sc.nextInt();
        int xxxx = sc.nextInt();
        int yyyy = sc.nextInt();

        System.out.printf("0%d-%d-%d", start, yyyy, xxxx);
    }
}