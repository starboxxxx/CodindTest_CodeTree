import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i<n; i++) {
            int[] num = new int[n];
            for (int z = 0; z<n; z++) {
                if (z == i) {
                    num[z] = arr[z] * 2;
                }
                else {
                    num[z] = arr[z];
                }
            }
            for (int j = 0; j<n; j++) {
                if (j == i) {
                    continue;
                }
                int total = 0;
                for (int h = 0; h<n-1; h++) {
                    if (h != j) {
                        if (h+1 == j) {
                            if (j != n-1) {
                                total += Math.abs(num[h+2] - num[h]);
                            }
                        }
                        else {
                            total += Math.abs(num[h+1] - num[h]);
                        }
                    }
                }
                if (total < min) {
                    min = total;
                }
            }
        }

        System.out.print(min);
    }
}