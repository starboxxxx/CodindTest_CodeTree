import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        
        int[] seat = new int[n];

        for (int i = 0; i<n; i++) {
            seat[i] = seats.charAt(i) - '0';
        }

        int max = 0;
        if (seat[0] == 0) {
            seat[0] = 1;

            int min1 = Integer.MAX_VALUE;
        
            for (int i = 0; i<n; i++) {
                if (seat[i] == 1) {
                    for (int j = i+1; j<n; j++) {
                        if (seat[j] == 1) {
                            min1 = Math.min(min1, j-i);
                            break;
                        }
                    }
                }
            }
            seat[0] = 0;
            max = Math.max(max, min1);
        }

        if (seat[n-1] == 0) {
            seat[n-1] = 1;

            int min2 = Integer.MAX_VALUE;

            for (int i = 0; i<n-1; i++) {
                if (seat[i] == 1) {
                    for (int j = i+1; j<n; j++) {
                        if (seat[j] == 1) {
                            min2 = Math.min(min2, j-i);
                            break;
                        }
                    }
                }
            }
            seat[n-1] = 0;
            max = Math.max(max, min2);
        }

        int x = 0;
        int y = 0;
        int count = 0;

        for (int i = 0; i<n; i++) {
            if (seat[i] == 1) {
                for (int j = i+1; j<n; j++) {
                    if (seat[j] == 1) {
                        if (j-i > count) {
                            count = j-i;
                            x = i;
                            y = j;
                        }
                        break;
                    }
                }
            }
        }

        seat[(x+y) / 2] = 1;


        int min3 = Integer.MAX_VALUE;

        for (int i = 0; i<n; i++) {

            if (seat[i] == 1) {
                for (int j = i+1; j<n; j++) {
                    if (seat[j] == 1) {
                        if (j-i < min3) {
                            min3 = j-i;
                        }
                        break;
                    }
                }
            }
        }

        int answer = Math.max(max, min3);

        System.out.print(answer);
    }
}