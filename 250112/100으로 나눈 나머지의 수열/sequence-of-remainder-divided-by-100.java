import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = N - 3;
        if (N == 1) {
            System.out.print(2);
        }
        else if (N == 2) {
            System.out.print(4);
        }
        else {
            System.out.print(printResult(num, 2, 4));
        }
    }

    public static int printResult(int total, int a, int b) {
        int num = (a * b) % 100;

        if (total == 0) {
            return num;
        }

        total--;
        return printResult(total, b, num);
    }
}