import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] cow = new int[N];

        for (int i = 0; i<N; i++) {
            cow[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                for (int k = j+1; k<N; k++) {
                    if ((i < j && j < k) && (cow[i] <= cow[j] && cow[j] <= cow[k])) {
                        count++;
                    } 
                }
            }
        }
        System.out.print(count);
    }
}