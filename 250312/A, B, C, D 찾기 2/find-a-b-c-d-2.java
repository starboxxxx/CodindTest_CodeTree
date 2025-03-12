import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int A = arr[0];
        int B = arr[1];

        Boolean isTrue = false;
        
        for (int i = 2; i<14; i++) {
            for (int j = i+1; j<15; j++) {
                if (A + arr[i] + arr[j] == arr[12]
                && B + arr[i] + arr[j] == arr[13]
                && A + B + arr[i] + arr[j] == arr[14]) {
                    System.out.print(A + " " + B + " " + arr[i] + " " + arr[j]);
                    isTrue = true;
                    break;
                }
            }
            if (isTrue) {
                break;
            }
        }
    }
}