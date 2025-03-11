import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();

        int[] seats = new int[n];

        for (int i = 0; i<n; i++) {
            seats[i] = seat.charAt(i) - '0';
        }

        int max = 0;
        
        for (int i = 0; i<n; i++) {
            int total = Integer.MAX_VALUE;
            if (seats[i] == 0) {
                seats[i] = 1;
                for (int j = 0; j<n-1; j++) {
                    if (seats[j] == 1) {
                        for (int z = j+1; z<n; z++) {
                            if (seats[z] == 1) {
                                total = Math.min(total, Math.abs(z-j));
                                break;
                            }
                        }
                    }
                }

                if (total > max) {
                    max = total;
                }
                seats[i] = 0;
            }
        }

        System.out.print(max);
        
    }
}