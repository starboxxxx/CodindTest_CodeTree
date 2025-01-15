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
        Person[] p = new Person[n];

        for (int i = 0; i<n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            Person person = new Person(name, height, weight);
            p[i] = person;
        }

        Arrays.sort(p, (a, b) -> a.height - b.height);

        for (int i = 0; i<n; i++) {
            System.out.println(p[i].name + " " + p[i].height + " " + p[i].weight);
        }
    }
}