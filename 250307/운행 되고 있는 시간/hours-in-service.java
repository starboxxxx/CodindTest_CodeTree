import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int answer = 0;
        
        for (int i = 0; i<N; i++) {
            int[] time = new int[1001];
            int count = 0;
            for (int j = 0; j<N; j++) {
                if(j == i) {
                    continue;
                }

                for (int z = A[j]; z<B[j]; z++) {
                    if (time[z] == 0) {
                        time[z] = 1;
                    }
                }
            }

            for (int k = 1; k<1001; k++) {
                if (time[k] != 0) {
                    count++;
                }
            }

            if (count > answer) {
                answer = count;
            }
        }

        System.out.print(answer);
    }
}