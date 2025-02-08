import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int current = 0;
        int count = 1;
        int max = 0;
        for (int i = 0; i<N; i++) {
            int num = sc.nextInt();
            if (num != current) {
                current = num;
                if (count>max) {
                    max = count;
                }
                count=1;
            }
            else {
                count++;
            }
        }

        System.out.print(max);
    }
}