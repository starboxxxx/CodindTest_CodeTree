import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        if (A == 1) {
            System.out.print("John");
        }
        else if (A == 2) {
            System.out.print("Tom");
        }
        else if(A == 3) {
            System.out.print("Paul");
        }
        else {
            System.out.print("Vacancy");
        }
    }
}