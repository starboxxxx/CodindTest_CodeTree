import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;
        if (input.length() < 4) {
            System.out.print(count);
        }
        else {
            for (int i=1; i<=input.length()-3; i++) {
                if(input.charAt(i-1) == '(' && input.charAt(i) == '(') {
                    for (int j = i+2; j<input.length(); j++) {
                        if (input.charAt(j-1) == ')' && input.charAt(j) == ')') {
                            count++;
                        }
                    }
                }
            }
            System.out.print(count);
        }
    }
}