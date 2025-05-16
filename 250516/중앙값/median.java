import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr;
        while(t-- > 0) {
            int m = sc.nextInt();
            arr = new int[m];
            for (int i = 0; i<m; i++) {
                arr[i] = sc.nextInt();
            }
            int mid = arr[0];
            PriorityQueue<Integer> maxPq = new PriorityQueue<>();
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            System.out.print(mid + " ");
            for(int i = 1; i < m; i++) {
                if ((i + 1) % 2 == 0) {
                    if (arr[i] < mid) {
                        maxPq.add(-arr[i]);
                    }
                    else {
                        minPq.add(arr[i]);
                    }
                }
                else {
                    int newMid;
                    if (maxPq.size() > minPq.size()) {
                        newMid = -maxPq.poll();
                    }
                    else{
                        newMid = minPq.poll();
                    }

                    int[] nums = new int[3];
                    nums[0] = mid;
                    nums[1] = arr[i];
                    nums[2] = newMid;

                    Arrays.sort(nums);

                    maxPq.add(-nums[0]);
                    mid = nums[1];
                    minPq.add(nums[2]);
                    System.out.print(mid + " ");
                }
            }
            System.out.println();
        }
    }
}