import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        int[] s = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int price = 0;
            int count = 0;
            price += p[i] / 2;
            price += s[i];

            if (price > b) {
                break;
            }
            count++;

            int[] total = new int[n];
            for (int  j = 0; j<n; j++) {
                if (j == i) {
                    continue;
                }
                total[j] = p[j] + s[j];
            }

            Arrays.sort(total);

            for (int k = 1; k<n; k++) {
                price += total[k];

                if (price > b) {
                    if (count > max) {
                        max = count;
                    }
                    break;
                }

                count++;
            }
        }

        System.out.print(max);
    }
}