import java.util.*;

class People implements Comparable<People> {
    int day;
    int v;
    int index;

    public People (int day, int v, int index) {
        this.day = day;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo (People p) {
        if (this.day != p.day) {
            return this.day - p.day;
        }

        return p.v - this.v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<People> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list.add(new People(s, 1, i));
            list.add(new People(e, -1, i));
        }

        Collections.sort(list);

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> room = new TreeSet<>();


        for (int i = 1; i<=n; i++) {
            room.add(i);
        }

        int[] num = new int[n+1];

        int count = 0;

        for (int i = 0; i<n; i++) {
            int day = list.get(i).day;
            int v = list.get(i).v;
            int index = list.get(i).index;

            if (v == 1) {
                int k = room.first();
                map.put(index, k);
                room.remove(k);
                if (num[k] == 0) {
                    count++;
                    num[k] = 1;
                }
            }

            else {
                int k = map.get(index);
                room.add(k);
            }
        }

        System.out.print(count);
    }
}