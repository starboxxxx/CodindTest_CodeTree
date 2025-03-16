import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int M = sc.nextInt();

        int p = sc.nextInt();

        char[] message = new char[M];
        int[] people = new int[M];

        for (int i = 0; i<M; i++) {
            message[i] = sc.next().charAt(0);
            people[i] = sc.nextInt();
        }

        for (char c = 'A'; c<'A' + N; c++) {
            for (int j = p-1; j<N; j++) {
                if (message[j] == c) {
                    break;
                }

                if (j == N-1) {
                    System.out.print(c + " ");
                }
            }
        }
    }
}