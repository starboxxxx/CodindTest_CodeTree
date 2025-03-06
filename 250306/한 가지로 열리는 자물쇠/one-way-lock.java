import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int count = 0;
        
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                for (int z = 1; z<=n; z++) {
                    if ((Math.abs(i-a) <= 2) || (Math.abs(j-b) <= 2) || (Math.abs(z-c) <= 2)) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}