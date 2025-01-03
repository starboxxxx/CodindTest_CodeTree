import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char A = sc.next().charAt(0);
        char B = sc.next().charAt(0);

        System.out.print((int) A + (int) B + " ");

        if ((int)A>=(int)B) {
            System.out.print((int)A - (int)B);
        }
        else {
            System.out.print((int)B - (int)A);
        }

        
    }
}