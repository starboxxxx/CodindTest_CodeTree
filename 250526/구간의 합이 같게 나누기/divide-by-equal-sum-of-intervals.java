import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        
        long[] sum = new long[n];

        long[] L = new long[n];
        long[] R = new long[n];

        L[0] = arr[0];
        for (int i = 1; i<n; i++) {
            L[i] = L[i-1] + arr[i];
        }

        R[n-1] = arr[n-1];
        for (int i = n-2; i>=0; i--) {
            R[i] = R[i+1] + arr[i];
        }
        
        int answer = 0;
        for (int i = 1; i<=n-2; i++) {
            
            int pivot = i;

            for (int j = 0; j<pivot; j++) {
                if (L[j] == L[pivot] - L[j]) {
                    for (int z = pivot+2; z<=n-1; z++) {
                        if (R[z] == R[pivot+1] - R[z]) {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}