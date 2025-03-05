import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int avg = 0;
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j = i; j<n; j++) {
                if (j == i) {
                    answer++;
                }
                else {
                    int total = 0;
                    for (int z = i; z<=j; z++) {
                        total += arr[z];
                    }

                    if (total % (j-i+1) == 0) {
                        avg = total / (j-i+1);
                        for (int z = i; z<=j; z++) {
                            if (arr[z] == avg) {
                                answer++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}