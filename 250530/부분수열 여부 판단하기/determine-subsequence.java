import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n+1];
        int[] B = new int[m+1];

        for (int i = 1; i<=n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 1; i<=m; i++) {
            B[i] = sc.nextInt();
        }

        int j = 1;
        boolean can = true;
        for (int i = 1; i<=m; i++) {

            while (j <= n && B[i] != A[j]) {
                j++;
            }

            if (j == n+1) {
                can = false;
                break;
            }
            else {
                j++;
            }
        }

        if (can) {
            System.out.print("Yes");
        } 
        else {
            System.out.print("No");
        }
    }
}