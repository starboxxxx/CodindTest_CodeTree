import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int[] countX = new int[11];
        int[] countY = new int[11];


        int count = 0;
        for (int i = 0; i<n; i++) {
            if (countX[x[i]] == 0 && countY[y[i]] == 0) {
                countX[x[i]] = 1;
                countY[y[i]] = 1;
                
                count++;
            }
        }

        if (count <= 3) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }


    }
}