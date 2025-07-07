import java.util.*;

class Number implements Comparable<Number> {
    int num;

    public Number (int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Number n) {
        int a = this.num;
        int b = n.num;

        long x = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        long y = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        return Long.compare(x, y);
    } 
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Number[] num = new Number[n];
        for (int i = 0; i < n; i++) {
            num[i] = new Number(sc.nextInt());
        }
        
        Arrays.sort(num);

        for (int i = n-1; i>=0; i--) {
            System.out.print(num[i].num);
        }
    }
}