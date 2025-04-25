import java.util.*;

class Work implements Comparable<Work> {
    int x;
    int y;
    int money;

    public Work(int x, int y, int money) {
        this.x = x;
        this.y = y;
        this.money = money;
    }

    public int compareTo(Work w) {
        return this.x - w.x;
    }
}

public class Main {

    public static int n;
    public static Work[] works;
    public static int[] count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        works = new Work[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();

            works[i] = new Work(s, e, p);
            count[i] = p;
        }
        
        Arrays.sort(works, 0, n);

        System.out.print(dp());
    }

    public static int dp() {

        for (int i = 1; i<n; i++) {
            int total = works[i].money;
            for (int j = 0; j<i; j++) {

                int s = works[i].x;
                int e = works[j].y;

                if (e < s) {
                    count[i] = Math.max(count[i], count[j] + total);
                }
            }
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            max = Math.max(max, count[i]);
        }

        return max;
    }
}