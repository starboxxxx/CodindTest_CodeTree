import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        

        int min = Integer.MAX_VALUE;

        min = Math.min(min, Math.abs(A - B));
        min = Math.min(min, Math.abs(A - x) + Math.abs(B - y));
        min = Math.min(min, Math.abs(A - y) + Math.abs(B - x));

        System.out.print(min);
    }
}