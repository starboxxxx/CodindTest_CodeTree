import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] result = new char[a.length()];

        for (int i = 0; i<a.length(); i++) {
            result[i] = a.charAt(i);
        }

        for (int i = 1; i<a.length(); i++) {
            if (result[i] == '0') {
                result[i] = '1';
                break;
            }
        }

        int number = 0;

        for (int i = 0; i<a.length(); i++) {
            number = number * 2 + (result[i]-'0');
        }

        if (a.equals("1")) {
            System.out.print(0);
        }
        else {
            System.out.print(number);   
        }
    }
}