import java.util.*;

class People implements Comparable<People> {
    int start;
    int speed;

    public People (int start, int speed) {
        this.start = start;
        this.speed = speed;
    }

    @Override
    public int compareTo(People p) {
        return this.start - p.start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        TreeSet<People> list = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int speed = sc.nextInt();
            list.add(new People(start, speed));
        }

        People people = list.first();
        people = list.higher(people);

        while (true) {

            if (list.lower(people) != null ) {
                People before = list.lower(people);
                if (before.start * before.speed * t >= people.start + people.speed * t) {
                    list.remove(before);
                }
            }

            if (list.higher(people) == null) {
                break;
            }

            People after = list.higher(people);
            if (people.start + people.speed * t >= after.start + after.speed * t) {
                list.remove(people);
            }

            people = list.higher(people);
        }


        System.out.print(list.size());


    }
}