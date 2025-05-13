import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            if (!set1.contains(A[i])) {
                set1.add(A[i]);
            }
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
            if (!set2.contains(B[i])) {
                set2.add(B[i]);
            }
        }

        int count = 0;

        for (int i = 0; i<n; i++) {
            if (!set2.contains(A[i])) {
                if (!result.contains(A[i])) {
                    result.add(A[i]);
                    count++;
                }
            }
        }

        for (int i = 0; i<m; i++) {
            if (!set1.contains(B[i])) {
                if (!result.contains(B[i])) {
                    result.add(B[i]);
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}