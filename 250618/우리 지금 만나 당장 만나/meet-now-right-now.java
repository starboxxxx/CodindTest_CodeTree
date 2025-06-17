import java.util.*;

class Person implements Comparable<Person> {
    int start;
    int speed;

    public Person(int start, int speed) {
        this.start = start;
        this.speed = speed;
    }

    @Override
    public int compareTo(Person p) {
        if (this.start != p.start) {
            return this.start - p.start;
        }
        return this.speed - p.speed;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] x1 = new int[n];
        int[] v1 = new int[n];
        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
        }

        for (int i = 0; i<n; i++) {
            v1[i] = sc.nextInt();
        }

        for (int i = 0; i<n; i++) {
            person[i] = new Person(x1[i], v1[i]);
        }

        Arrays.sort(person);

        int left = -2000000000;
        int right = 2000000000;
        double answer = 2000000000.0;

        while (left <= right) {
            int mid = (left + right) / 2;
            double max = -1;
            int index = -1;
            for (int i = 0; i<n; i++) {
                double x = (double) (Math.abs(person[i].start - mid)) / person[i].speed;
                if (x > max) {
                    max = x;
                    index = i;
                }
            }

            if (person[index].start >= mid) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }

            answer = Math.min(answer, max);
        }

        System.out.printf("%.4f", answer);
    }
}