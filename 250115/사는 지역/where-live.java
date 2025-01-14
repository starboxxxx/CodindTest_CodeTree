import java.util.*;

class Person {
    String name;
    String local;
    String city;

    public Person(String name, String local, String city) {
        this.name = name;
        this.local = local;
        this.city = city;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        String[] dict = new String[n];
        Person[] p = new Person[n];

        for (int i = 0; i<n; i++) {
            String name = sc.next();
            String local = sc.next();
            String city = sc.next();

            dict[i] = name;
            Person person = new Person(name, local, city);
            p[i] = person; 
        }

        Arrays.sort(dict);

        for (int i = 0; i<n; i++) {
            if (p[i].name.equals(dict[n-1])) {
                System.out.println("name " + p[i].name);
                System.out.println("addr " + p[i].local);
                System.out.println("city " + p[i].city);
                break;
            }
        }


    }
}