import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int count = 0;
        
        for (int i = x; i<=y; i++) {
            String word = String.valueOf(i);
            boolean isSame = true;
            for (int j = 0; j<word.length(); j++) {
                if (word.charAt(j) == word.charAt(word.length() - 1 - j)) {
                    continue;
                }

                isSame = false;
                break;
            }

            if (isSame == true) {
                count++;
            }
        }

        System.out.print(count);
    }
}