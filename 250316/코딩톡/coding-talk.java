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
            if (people[p-1] == 0) {
                break;
            }
            boolean isTrue = true;

            for (int z = p-2; z>=0; z--) {
                if (people[z] != people[p-1]) {
                    break;
                }

                if (message[z] == c) {
                    isTrue = false;
                    break;
                }
            }

            if (isTrue) {
                for (int j = p-1; j<M; j++) {
                    if (message[j] == c) {
                        break;
                    }

                    if (j == M-1) {
                        System.out.print(c + " ");
                    }
                }
            }
        }
    }
}