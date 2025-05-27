import java.util.*;

class Person implements Comparable<Person> {
    int time;
    int v;
    int index;

    public Person (int time, int v, int index) {
        this.time = time;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Person p) {
        if (this.time != p.time) {
            return this.time - p.time;
        }
        return this.v - p.v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            list.add(new Person(start, 1, i));
            list.add(new Person(end, -1, i));
        }
        
        Collections.sort(list);

        TreeMap<Integer, Integer> set = new TreeMap<>();
        TreeSet<Integer> finish = new TreeSet<>();
        for (int i = 1; i<=n; i++) {
            finish.add(i);
        }

        int[] use = new int[n];

        int min = Integer.MIN_VALUE;
        for (int i = 0; i<2*n; i++) {
            int time = list.get(i).time;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (v==1) {
                int k = finish.first();
                use[index] = k;
                set.put(index, k);
                finish.remove(k);
            }

            else {
                int k = set.get(index);
                finish.add(k);
                set.remove(index);
            }
        }

        for (int i = 0; i<n; i++) {
            System.out.print(use[i] + " ");
        }


    }
}