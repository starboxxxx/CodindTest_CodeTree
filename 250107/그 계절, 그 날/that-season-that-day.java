import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        System.out.print(check(Y, M, D));
    }

    public static String check(int Y, int M, int D) {
        if (Y % 4 == 0) {
            if (Y % 100 != 0 || (Y % 100 == 0 && Y % 400 == 0)) {
                if (checkDate(true, M, D)) {
                    return checkSeason(M);
                }
                else {
                    return "-1";
                }
            }
            else {
                if (checkDate(false, M, D)) {
                    return checkSeason(M);
                }
                else {
                    return "-1";
                }
            }
        }
        else {
            if (checkDate(false, M, D)) {
                return checkSeason(M);
            }
            else {
                return "-1";
            }
        }
    }

    public static boolean checkDate(boolean year, int M, int D) {
        if (M == 2) {
            if (year) {
                if (D >= 1 && D <= 29) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                if (D >= 1 && D <= 28) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else if (M == 4 || M == 6 || M == 9 || M == 11) {
            if (D >= 1 && D <= 30) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (D >= 1 && D <= 31) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static String checkSeason(int M) {
        if (M >= 3 && M <= 5) {
            return "Spring";
        }
        else if (M >= 6 && M <= 8) {
            return "Summer";
        }
        else if (M >= 9 && M <= 11) {
            return "Fall";
        }
        else {
            return "Winter";
        }
    }
}