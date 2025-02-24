import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] result = new char[a.length()];

        for (int i = 0; i<a.length(); i++) {
            result[i] = a.charAt(i);
        }

        char original;

        int max = 0;

        for (int i = 1; i<a.length(); i++) {
            if (result[i] == '0') {
                original = '0';
                result[i] = '1';
            }
            else {
                original = '1';
                result[i] = '0';
            }

            int number = 0;

            for (int j = 0; j<a.length(); j++) {
                number = number * 2 + (result[j]-'0');
            }

            if (number > max) {
                max = number;
            }
            
            result[i] = original;
        }

        if (a.equals("1")) {
            System.out.print(0);
        }
        else {
            System.out.print(max);   
        }
    }
}