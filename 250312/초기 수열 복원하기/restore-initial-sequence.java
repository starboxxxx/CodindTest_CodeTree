import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n-1];

        for (int i = 0; i<n-1; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i<n; i++) {
            boolean isTrue = true;
            int count = 0;
            int[] num = new int[n];
            num[0] = i;
            for (int j = 0; j<n-1; j++) {
                if (arr[j] - num[j] <= n && arr[j] - num[j] >= 1) {
                    int x = arr[j] - num[j];
                    for (int z = 0; z<n; z++) {
                        if (x == num[z]) {
                            isTrue = false;
                            break;
                        }

                        if (z == n-1) {
                            num[j+1] = x;
                        }
                    }
                    if (j == n-2 && isTrue) {
                        for (int z = 0; z<n; z++) {
                            System.out.print(num[z] + " ");
                        }
                    }
                }
            }
        }
        

    }
}