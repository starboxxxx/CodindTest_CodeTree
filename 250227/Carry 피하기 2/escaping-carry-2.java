import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] num = new int[N];

        int max = 0;

        int[] targetNum = new int[3];

        for (int i = 0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                for (int z = j+1; z<N; z++) {
                    targetNum[0] = num[i];
                    targetNum[1] = num[j];
                    targetNum[2] = num[z];
                    int result = calculate(targetNum);
                    if (result!=0) {
                        if (result > max) {
                            max = result;
                        }
                    }
                }
            }
        }

        if (max == 0) {
            System.out.print(-1);
        }
        else {
            System.out.print(max);
        }
    }

    public static int calculate(int[] targetNum) {
        int result = targetNum[0] + targetNum[1] + targetNum[2];
        while (true) {
            int total = 0;
            for (int i = 0; i<3; i++) {
                if (targetNum[i] != 0) {
                    total += targetNum[i] % 10;
                    targetNum[i] /= 10;
                }
            }

            if (total >= 10) {
                return 0;
            }
            else if (targetNum[0] == 0 && targetNum[1] == 0 && targetNum[2] == 0) {
                return result;
            }
        }
    }
}