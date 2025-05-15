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

            if (list.higher(people) == null) {
                break;
            }

            People people1 = list.higher(people);
            People people2 = list.lower(people);

            int total = people.start + people.speed * t;
            int total1 = people1.start + people1.speed * t;
            int total2 = people2.start + people2.speed * t;

            if (total >= total1 && total <= total2) {
                int t1 = (people1.start - people.start) / (people.speed - people1.speed);
                int t2 = (people.start - people2.start) / (people2.speed - people.speed);
            
                if (t1 < t2) {
                    list.remove(people);
                }
                else if (t1 > t2) {
                    list.remove(people2);
                }
                else {
                    list.remove(people);
                    list.remove(people2);
                }
            }
            else if (total >= total1) {
                list.remove(people);
            }
            else if (total <= total2){
                list.remove(people2);
            }

            people = people1;
        }


        System.out.print(list.size());


    }
}