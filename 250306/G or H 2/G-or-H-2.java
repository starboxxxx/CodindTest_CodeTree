import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] alpha = new char[101];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            alpha[position] = ch;
        }
    
        int max = 0;

        for (int i = 0; i<100; i++) {
            for (int j = 1; j<=100-i; j++) {
                int countG = 0;
                int countH = 0;
                int f = 0;
                int l = 0;
                boolean first = false;
                for (int z = i; z<=i+j; z++) {
                    if (alpha[z] == 'G') {
                        countG++;
                        if (first == false) {
                            f = z;
                            first = true;
                        }
                        else {
                            l = z;
                        }
                    }
                    else if (alpha[z] == 'H') {
                        countH++;
                        if (first == false) {
                            f = z;
                            first = true;
                        }
                        else {
                            l = z;
                        }
                    }
                }
                if (countG != 0 && countH != 0 && countG == countH) {
                    int length = l - f;
                    if (length > max) {
                        max = length;
                    }
                }
                else if ((countG != 0 && countH == 0) || 
                (countG == 0 && countH != 0)) {
                    int length = l - f;
                    if (length > max) {
                        max = length;
                    }
                } 
            }
        }
        System.out.print(max);
    }
}