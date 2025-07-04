import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        long left = 0;
        long right = 100000;

        int answer = Integer.MIN_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            ArrayList<Integer> list = new ArrayList<>();

            int result = 0;
            for (int i = 0; i<n; i++) {
                if (arr[i] < mid) {
                    list.add(arr[i]);
                }
                else {
                    result++;
                }
            }

            Collections.sort(list);
            
            int current = list.size()-1;
            long count = k * l;
            while (current >= 0) {
                long num = (long) list.get(current);

                if (mid - num <= k && mid - num <= count) {
                    count -= (mid-num);
                    result++;
                    current--;
                }
                else {
                    break;
                }
            }

            if (result >= mid) {
                left = mid+1;
                answer = Math.max(answer, (int) mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.print(answer);
    }
}