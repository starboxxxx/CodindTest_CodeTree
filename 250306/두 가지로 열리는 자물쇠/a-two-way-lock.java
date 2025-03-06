import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();

        int count=0;
        
        for (int i = 1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int z=1; z<=n; z++) {
                    if ((Math.abs(i - a) <= 2 || Math.abs(i-a) >= n-2) && 
                    (Math.abs(j - b) <= 2 || Math.abs(j - b) >= n-2) && 
                    (Math.abs(z - c) <= 2 || Math.abs(z - c) >= n-2)) {
                        count++;
                    }
                    else if ((Math.abs(i - a2) <= 2 || Math.abs(i-a2) >= n-2) && 
                    (Math.abs(j - b2) <= 2 || Math.abs(j - b2) >= n-2) && 
                    (Math.abs(z - c2) <= 2 || Math.abs(z - c2) >= n-2)) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}