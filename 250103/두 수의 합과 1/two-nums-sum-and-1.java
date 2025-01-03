import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int total = A + B;
        int ans = 0;

        String result = String.valueOf(total);

        for(int i = 0; i<result.length(); i++) {
            if (result.charAt(i) == '1') {
                ans++;
            }
        }
        System.out.print(ans);
    }
}