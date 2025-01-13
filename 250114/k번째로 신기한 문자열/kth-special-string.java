import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        char[] T = sc.next().toCharArray();

        List<String> dict = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            char[] A = sc.next().toCharArray();

            if (A[0] == T[0] && A[1] == T[1]) {
                dict.add(new String(A));
            }
        }

        Collections.sort(dict);

        System.out.print(dict.get(k-1));
    }
}