import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        
        int[] seat = new int[N];

        for (int i = 0; i<N; i++) {
            seat[i] = seats.charAt(i) - '0';
        }

        int max = 0;

        for (int i = 0; i<N-1; i++) {
            for (int j = i+1; j<N; j++) {
                if (seat[j] == 1 && seat[i] == 1) {
                    if (j - i > max) {
                        max = j - i;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i<N-1; i++) {
            boolean isTrue = true;
            for (int j = i+1; j<N; j++) {
                if (seat[j] == 1 && seat[i] == 1) {
                    if (j - i == max) {
                        int current = i + (j - i) / 2;
                        seat[current] = 1;
                        isTrue = false;
                        break;
                    }
                }
            }
            if (isTrue == false) {
                break;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<N-1; i++) {
            for (int j = i+1; j<N; j++) {
                if (seat[j] == 1 && seat[i] == 1) {
                    if (j - i < min) {
                        min = j - i;
                    }
                    break;
                }
            }
        }

        System.out.print(min);
    }
}