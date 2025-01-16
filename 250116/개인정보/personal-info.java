import java.util.*;

class Person {
    int height;
    double weight;
    String name;

    public Person(int height, double weight, String name) {
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person[] persons = new Person[5];


        for (int i = 0; i<5; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            double weight = sc.nextDouble();

            Person person = new Person(height, weight, name);
            persons[i] = person;
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.name.compareTo(b.name);
            }
        });

        System.out.println("name");
        for (int i = 0; i<5; i++) {
            System.out.println(persons[i].name + " " + persons[i].height + " " + persons[i].weight);
        }

        System.out.println();

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return b.height - a.height;
            }
        });

        System.out.println("height");
        for (int i = 0; i<5; i++) {
            System.out.println(persons[i].name + " " + persons[i].height + " " + persons[i].weight);
        }
    }
}