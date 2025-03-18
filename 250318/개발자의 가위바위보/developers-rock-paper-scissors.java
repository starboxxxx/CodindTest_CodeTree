import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int[] count = new int[6];

        for (int i = 0; i<n; i++) {
            if ((A[i] == 1 && B[i] == 2)  || (A[i]==2 && B[i]==3) || (A[i]==3 && B[i] == 1)) {
                count[0]++;
            }

            if ((A[i] == 1 && B[i] == 3) || (A[i] == 2 && B[i] == 1) || (A[i] == 3 && B[i] == 2)) {
                count[1]++;
            }

            if ((A[i] == 2 && B[i] == 1) || (A[i] == 1 && B[i] == 3) || (A[i] == 3 && B[i] == 2)) {
                count[2]++;
            }

            if ((A[i] == 2 && B[i] == 3) || (A[i] == 1 && B[i] == 2) || (A[i] == 3 && B[i] == 1)) {
                count[3]++;
            }

            if ((A[i] == 3 && B[i] == 1) || (A[i] == 1 && B[i] == 2) || (A[i] == 2 && B[i] == 3)) {
                count[4]++;
            }

            if ((A[i] == 3 && B[i] == 2) || (A[i] == 1 && B[i] == 3) || (A[i] == 2 && B[i] == 1)) {
                count[5]++;
            }
        }

        int max = 0;
        
        for (int i = 0; i<6; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        System.out.print(max);
        
    }
}