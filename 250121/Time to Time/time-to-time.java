import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = sc.nextInt();
        int d = sc.nextInt();

        int min1 = a * 60 + b;
        int min2 = c * 60 + d;

        System.out.println(min2 - min1);

        
    }
}