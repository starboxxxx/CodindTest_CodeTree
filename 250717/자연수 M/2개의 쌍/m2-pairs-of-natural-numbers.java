import java.util.*;

class Number implements Comparable<Number> {
    int num;
    int count;

    public Number(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Number n) {
        return this.num - n.num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Number> k = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            k.add(new Number(y, x));
        }

        Collections.sort(k);
        int p = 0;
        int q = n-1;
        int start = k.get(0).count;
        int end = k.get(n-1).count;
        int max = Integer.MIN_VALUE;
        int total = 0;

        while (total < n/2) {
            max = Math.max(max, k.get(p).num + k.get(q).num);

            if (start == end) {
                p++;
                q--;
                total += start;
                start = k.get(p).count;
                end = k.get(q).count;
            }

            else if (start > end) {
                start -= end;
                total += end;
                q--;
                end = k.get(q).count;
            }

            else {
                end -= start;
                total += start;
                p++;
                start = k.get(p).count;
            }
        }

        System.out.print(max);
        
    }
}