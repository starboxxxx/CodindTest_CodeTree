import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] birds = new int[N];

        for (int i = 0; i<N; i++) {
            birds[i] = -1;
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (birds[a] == -1) {
                birds[a] = b;
            }

            else {
                if ((b == 0 && birds[a] == 1) || (b == 1 && birds[a] == 0)) {
                    count++;
                }
                birds[a] = b;
            }
        }

        System.out.print(count);

    }
}