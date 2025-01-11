import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int max = 0;

        for (int i = 0; i<n; i++) {
            num[i] = sc.nextInt();
            if (num[i] > max) {
                max = num[i];
            }
        }

        System.out.print(printResult(max, num));
    }

    public static int printResult(int max, int[] num) {
        for (int i = 0; i<num.length; i++) {
            if (max % num[i] != 0) {
                break;
            }
            else if (i == num.length-1) {
                return max;
            }
        }
        return printResult(max + 1, num);
    }
}