import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String A = sc.next();

        int n = Arrays.asList(weeks).indexOf(A);

        int count = 1;

        int day1 = 0;
        int day2 = 0;

        for (int i = 1; i<m1; i++) {
            day1 += days[i];
        }        
        day1 += d1;

        for (int i = 1; i<m2; i++) {
            day2 += days[i];
        }
        day2 += d1;

        int total = day2 - day1 + n;

        count += total / 7;

        System.out.print(count);

    }
}