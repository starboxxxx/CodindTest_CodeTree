import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fires = new int[n];
        int[] stations = new int[m];
        for (int i = 0; i < n; i++)
            fires[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            stations[i] = sc.nextInt();
        
        Arrays.sort(fires);
        Arrays.sort(stations);

        int j = 0;
        long distance = (long)Math.abs(stations[0] - fires[0]);
        long answer = 0;

        for (int i = 0; i<n; i++) {
            while (j+1 < m && (long)Math.abs(fires[i] - stations[j+1]) <= distance) {
                answer = (long)Math.max(answer, (long)Math.abs(fires[i] - stations[j+1]));
                j++;
            }

            if (i+1 < n) {
                distance = (long)Math.abs(stations[j] - fires[i+1]);
                if (i+1 == n-1) {
                    answer = (long)Math.max(answer, distance);
                }
            }
        }

        System.out.print(answer);
    }
}