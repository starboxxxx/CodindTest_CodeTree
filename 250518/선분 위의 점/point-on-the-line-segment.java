import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        Arrays.sort(points);

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            int minArr = n;
            int left = 0;
            int right = n-1;

            while (left <= right) {
                int mid = (left+right) / 2;
                
                if (points[mid] >= a) {
                    right = mid-1;
                    minArr = Math.min(minArr, mid);
                }
                else {
                    left = mid+1;
                }
            }

            int maxArr = -1;
            left = 0;
            right = n-1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (points[mid] <= b) {
                    left = mid+1;
                    maxArr = Math.max(maxArr, mid);
                } 
                else {
                    right = mid-1;
                }
            }

            System.out.println(maxArr - minArr + 1);
        }
    }
}