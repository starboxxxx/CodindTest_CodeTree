import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        int count = 0;
        int[] target = new int[M];

        for (int i = 0; i<=N-M; i++) {
            for (int a = 0; a<M; a++) {
                target[a] = B[a];
            }
            boolean beautiful = false;
            for (int j = i; j<i+M; j++) {
                for (int z = 0; z<M; z++) {
                    if (target[z] == A[j]) {
                        target[z] = 0;
                        break;
                    }

                    else if (z == M-1) {
                        beautiful = true;
                    }
                }
                if (beautiful == true) {
                    break;
                }
                else if (j == i+M-1) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}