import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        printHelloWorld(N);
    }

    public static void printHelloWorld(int n) {
        if (n == 0) {
            return;
        }
        printHelloWorld(n-1);
        System.out.println("HelloWorld");
    }
}