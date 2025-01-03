import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String m = Integer.toString(n);
        int total = 0;

        for(int i=0; i<m.length(); i++) {
            String k = String.valueOf(m.charAt(i));
            total += Integer.parseInt(k);
        }

        System.out.print(total);
    }
}