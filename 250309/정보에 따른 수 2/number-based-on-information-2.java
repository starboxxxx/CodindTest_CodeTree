import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[] c = new char[T];
        int[] pos = new int[T];
        for (int i = 0; i < T; i++) {
            c[i] = sc.next().charAt(0);
            pos[i] = sc.nextInt();
        }

        int count = 0;
        
        for (int i = a; i<=b; i++) {
            int minS = Integer.MAX_VALUE;
            int minN = Integer.MAX_VALUE;
            for (int j = 0; j<T; j++) {
                if (c[j] == 'S' && Math.abs(pos[j] - i) < minS) {
                    minS = Math.abs(pos[j] - i);
                }

                if (c[j] == 'N' && Math.abs(pos[j] - i) < minN) {
                    minN = Math.abs(pos[j] - i);
                }
            }

            if (minS <= minN) {
                count++;
            }
        }

        System.out.print(count);
    }
}