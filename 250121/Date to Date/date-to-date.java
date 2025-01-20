import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] month = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int day1 = 0;
        int day2 = 0;

        for (int i = 1; i<m1; i++) {
            day1 += month[i];
        }
        day1 += d1;

        for (int i = 1; i<m2; i++) {
            day2 += month[i];
        }
        day2 += d2;

        System.out.print(day2 - day1 + 1);
        
    }
}