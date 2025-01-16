import java.util.*;

class Person {
    String name;
    int height;
    int weight;

    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Person[] persons = new Person[n];

        for (int i=0; i<n; i++) {
            String name =sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            Person person = new Person(name, height, weight);
            persons[i] = person;
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                if (a.height == b.height) {
                    return b.weight - a.weight;
                }
                return a.height - b.height;
            }
        });

        for (int i=0; i<n; i++) {
            System.out.println(persons[i].name + " " + persons[i].height + " " + persons[i].weight);
        }
    }
}