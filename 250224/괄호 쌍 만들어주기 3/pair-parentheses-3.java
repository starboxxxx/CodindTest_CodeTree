import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();

        int count = 0;

        for (int i = 0; i<a.length(); i++) {
            if (a.charAt(i) == '(') {
                for (int j = i+1; j<a.length(); j++) {
                    if (a.charAt(j) == ')') {
                        count++;
                    }
                }
            }
        }


        System.out.println(count);


    }
}