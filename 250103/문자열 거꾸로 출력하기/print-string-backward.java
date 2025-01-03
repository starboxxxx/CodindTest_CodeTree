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
                StringBuffer sb = new StringBuffer(word);
                String result = sb.reverse().toString();
                System.out.println(result);
            }
        }
    }
}