import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        int[] people = new int[N];

        for (int i = 0; i<N; i++) {
            people[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i<N; i++) {
            int current = 0;

            for (int j = 0; j<N; j++) {
                current += people[j] * Math.abs(j - i);
            }

            if (current < answer) {
                answer = current;
            }
        }

        System.out.print(answer);

    }
}