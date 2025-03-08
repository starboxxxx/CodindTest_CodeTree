import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int count = 0;
        
        for (int i = 0; i<n-2; i++) {
            for (int j = i+1; j<n-1; j++) {
                for (int z = j+1; z<n; z++) {
                    boolean success = true;
                    for (int h = 0; h<n-1; h++) {
                        if (h == i || h == j || h == z) {
                            continue;
                        }
                        for (int k = h+1; k<n; k++) {
                            
                            if (k == i || k == j || k == z) {
                                continue;
                            }

                            if (b[h] < a[k] || a[h] > b[k]) {
                                continue;
                            }

                            success = false;
                        }
                    }

                    if (success == true) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}