import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];


        for (int i = 0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i<N; i++) {
            B[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i<N; i++) {
            if (A[i] > B[i]) {
                for (int j = i+1; j<N; j++) {
                    if (A[j] < B[j]) {
                        int k = A[i] - B[i];
                        for (int z = 1; z<=k; z++) {
                            if (A[j] == B[j]) {
                                break;
                            }

                            A[i]--;
                            A[j]++;
                            count += j-i;
                        }
                    }
                }
            }
        }

        System.out.print(count);
        

    }
}