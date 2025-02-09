import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] students = new int[N+1];

        int M = sc.nextInt();

        int K = sc.nextInt();

        for (int i = 0; i<M; i++) {
            int num = sc.nextInt();

            students[num]++;

            if (students[num]==K) {
                System.out.print(num);
                break;
            }   
            else if (i==M-1) {
                System.out.print(-1);
            }   
        }
    }
}