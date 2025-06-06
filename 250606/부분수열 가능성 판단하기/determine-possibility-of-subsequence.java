import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];

        for (int i = 0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        for (int j = 0; j<m; j++) {
            B[j] = sc.nextInt();
        }

        int[] L = new int[m];
        for (int i = 0; i<m; i++) {
            L[i] = -1;
        }
        int j = 0;
        for (int i = 0; i<n; i++) {

            if (j == m) {
                break;
            }

            if (A[i] == B[j]) {
                L[j] = i;
                j++;
            }
        }

        int[] R = new int[m];
        for (int i = 0; i<m; i++) {
            R[i] = -1;
        }

        j = m-1;
        for (int i = n-1; i>=0; i--) {
            if (j == -1) {
                break;
            }

            if (A[i] == B[j]) {
                R[j] = i;
                j--;
            }
        }

        int count = 0;

        if (R[1] != -1) {
            count++;
        }

        if (L[m-2] != -1) {
            count++;
        }

        for (int i = 1; i<m-1; i++) {

            if (L[i-1] != -1 && R[i+1] != -1 && L[i-1] < R[i+1]) {
                count++;
            }
        }

        System.out.print(count);
    }
}