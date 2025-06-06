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
        int distance = Math.abs(stations[0] - fires[0]);
        int answer = 0;

        for (int i = 0; i<n; i++) {
            while (j+1 < m && Math.abs(fires[i] - stations[j+1]) < distance) {
                distance = Math.abs(fires[i] - stations[j+1]);
                j++;
            }


            answer = Math.max(answer, Math.abs(fires[i] - stations[j]));

            if (i+1 < n) {
                distance = Math.abs(stations[j] - fires[i+1]);
            }
        }

        System.out.print(answer);
    }
}