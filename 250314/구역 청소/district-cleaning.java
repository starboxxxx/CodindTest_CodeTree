import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();


        if (a > d || b < c) {
            System.out.print(b-a + d-c);
        }
        else {
            int start;
            int end;
            if (a < c) {
                start = a;
            }
            else {
                start = c;
            }

            if (b < d) {
                end = d;
            }
            else {
                end = b;
            }

            System.out.print(end - start);
        }
    }
}