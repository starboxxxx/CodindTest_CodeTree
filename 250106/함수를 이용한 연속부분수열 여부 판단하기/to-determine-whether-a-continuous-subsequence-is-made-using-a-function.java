import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] A = new int[n1];
        int[] B = new int[n2];

        for (int i = 0; i<n1; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i<n2; i++) {
            B[i] = sc.nextInt();
        }

        System.out.print(check(n1, n2, A, B));
    }

    public static String check(int n1, int n2, int[] A, int[] B) {

        for (int i = 0; i<=n1-n2; i++) {
            int k = 0;
            for (int j = i; j<i+n2; j++) {
                if (A[j] != B[k]) {
                    break;
                }
                else if (j == i+n2-1) {
                    return "Yes";
                }
                else {
                    k++;
                }
            }
        }
        return "No";
    }
}