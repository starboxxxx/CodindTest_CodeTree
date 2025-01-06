import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int D = sc.nextInt();

        System.out.print(exist(M, D));
    }

    public static String exist(int M, int D) {
        if (M >= 1 && M <= 12) {
            if (M == 2) {
                if (D >=1 && D<=28) {
                    return "Yes";
                }
                else {
                    return "No";
                }
            }
            else if (M == 1 || M==3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12) {
                if (D >= 1 && D <= 31) {
                    return "Yes";
                }
                else {
                    return "No";
                }
            }
            else {
                if (D >= 1 && D <= 30) {
                    return "Yes";
                }
                else {
                    return "No";
                }
            }
        }
    }
}