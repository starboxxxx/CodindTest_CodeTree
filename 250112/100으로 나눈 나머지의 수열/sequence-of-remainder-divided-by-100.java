import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt()-3;
        System.out.print(printResult(N, 2, 4));
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