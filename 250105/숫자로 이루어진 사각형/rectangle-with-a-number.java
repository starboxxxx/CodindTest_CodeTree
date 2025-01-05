import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        printNum(N);

    }

    public static void printNum(int N) {
        int num = 1;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(num + " ");

                if (num == 9) {
                    num = 1;
                }
                else {
                    num++;
                }
            }
            System.out.println();
        }
    }
}