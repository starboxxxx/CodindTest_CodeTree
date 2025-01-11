import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 1;
        for (int i = 0; i<3; i++) {
            total *= sc.nextInt();
        }
        System.out.print(printTotal(total));
    }

    public static int printTotal(int total) {
        if (total < 10) {
            return total;
        }

        return printTotal(total / 10) + total % 10;
    }
}