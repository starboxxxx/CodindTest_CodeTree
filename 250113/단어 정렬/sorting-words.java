import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] alphas = new String[n];

        for (int i = 0; i<n; i++) {
            alphas[i] = sc.next();
        }

        Arrays.sort(alphas);

        for (int i = 0; i<n; i++) {
            System.out.println(alphas[i]);
        }
    }

}