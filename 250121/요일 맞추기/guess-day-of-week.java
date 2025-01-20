import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        int m2 = sc.nextInt();
        int d2= sc.nextInt();

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int day1 = 0;
        int day2 = 0;

        for (int i = 1; i<m1; i++) {
            day1 += days[i];
        }
        day1 += d1;

        for (int i=1; i<m2; i++) {
            day2 += days[i];
        }
        day2 += d2;

        int total = 0;

        if (day1 >= day2) {
            total = day1 - day2;
            int result = total % 7;

            if (result == 0) {
                System.out.print("Mon");
            }
            else {
                System.out.print(weeks[7-result]);
            }
        }

        else {
            total = day2 - day1;
            int result = total % 7;

            System.out.print(weeks[result]);
        }
    }
}