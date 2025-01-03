import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = new String[200];
        int total = 0;
        int i = 0;
        int k = 0;


        while (true) {
            String word = sc.next();

            if (word.equals("0")) {
                System.out.println(total);
                for (int j = 0; j<k; j++) {
                    System.out.println(words[j]);
                }
                break;
            }

            else if (i % 2 == 0) {
                words[k] = word;
                k++;
            }

            total++;
            i++;
        }
    }
}