import java.util.*;

class Tuple implements Comparable<Tuple>{
    int len;
    int s;
    int e;

    public Tuple(int len, int s, int e) {
        this.len = len;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Tuple t) {
        if (this.len != t.len) {
            return this.len - t.len;
        }
        else if (this.s != t.s) {
            return this.s - t.s;
        }
        else {
            return this.e - t.e;
        }
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        TreeSet<Tuple> tuple = new TreeSet<>();

        set.add(-1);
        set.add(n+1);

        tuple.add(new Tuple(n+1, -1, n+1));

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            set.add(k);

            int y = set.higher(k);
            int x = set.lower(k);

            tuple.remove(new Tuple(y-x-1, x, y));
            tuple.add(new Tuple(k-x-1, x, k));
            tuple.add(new Tuple(y-k-1, k, y));
            
            System.out.println(tuple.last().len);
        }
        

    }
}