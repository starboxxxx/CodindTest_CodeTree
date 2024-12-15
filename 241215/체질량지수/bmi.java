import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = (double)(sc.nextInt());
        double w = (double)(sc.nextInt());

        double b = (10000.0 * w) / (h * h);

        System.out.printf("%d\n", (int)b);

        if ((int)(b) >= 25) {
            System.out.print("Obesity");
        }
    }
}