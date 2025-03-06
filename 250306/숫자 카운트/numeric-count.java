import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        
        int answer = 0;
        for (int i = 1; i<=9; i++) {
            for (int j = 1; j<=9; j++) {
                for (int z = 1; z<=9; z++) {
                    if (i == j || j == z || z == i) {
                        continue;
                    }
                    for (int h = 0; h<n; h++) {
                        int sumA = 0;
                        int sumB = 0;
                        int a = num[h] / 100;
                        int b = (num[h] % 100) / 10;
                        int c = (num[h] % 100) % 10;

                        if (a == i) {
                            sumA++;
                        }
                        else if (a == j || a== z) {
                            sumB++;
                        }

                        if (b == j) {
                            sumA++;
                        }
                        else if (b == i || b == z) {
                            sumB++;
                        }

                        if (c == z) {
                            sumA++;
                        }
                        else if (c == i || c == j) {
                            sumB++;
                        }

                        if ((sumA!=count1[h]) || (sumB!=count2[h])) {
                            break;
                        }
                        else if (h == n-1) {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.print(answer);
        
    }
}