import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        int max = 0;
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        int A = arr[0];
        int B = arr[1];
        int C = 0;

        if (A+B == arr[2]) {
            C = arr[3];
        }

        else {
            C = arr[2];
        }

        int D = arr[14] - A - B - C;

        System.out.print(A + " " + B + " " + C + " " + D);
    }
}