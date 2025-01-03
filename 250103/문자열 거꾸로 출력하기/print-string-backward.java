import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = "";

        while (true) {
            word = sc.next();

            if (word.equals("END")) {
                break;
            }

            else {
                for (int i = word.length()-1; i>=0; i--) {
                    System.out.print(word.charAt(i));
                }
                System.out.println();
            }
        }
    }
}