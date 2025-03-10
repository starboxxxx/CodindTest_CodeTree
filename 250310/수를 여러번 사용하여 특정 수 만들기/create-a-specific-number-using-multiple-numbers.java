import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int max = 0;
        
        for (int i = 0; i<=C / A; i++) {
            for (int j = 0; j<=C / B; j++) {
                if (A * i + B * j <= C) {
                    int number = A * i + B * j;
                    max = Math.max(max, number);
                }
            }
        }

        System.out.print(max);
        
    }
}