import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int answer= 0;
        
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                for (int z = j+1; z<n; z++) {
                    int distanceX = 0;
                    int distanceY = 0;
                    if (x[i] == x[j] || x[j] == x[z] || x[z] == x[i]) {
                        if (y[i] == y[j] || y[j] == y[z] || y[z] == y[i]) {
                            if (x[i] == x[j]) {
                                distanceY = Math.abs(y[i] - y[j]);
                            }
                            else if (x[j] == x[z]) {
                                distanceY = Math.abs(y[j] - y[z]);
                            }
                            else {
                                distanceY = Math.abs(y[z] - y[i]);
                            }

                            if (y[i] == y[j]) {
                                distanceX = Math.abs(x[i] - x[j]);
                            }

                            else if (y[j] == y[z]) {
                                distanceX = Math.abs(x[j] - x[z]);
                            }
                            else {
                                distanceX = Math.abs(x[z] - x[i]);
                            }

                            if (distanceX * distanceY > answer) {
                                answer = distanceX * distanceY;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}