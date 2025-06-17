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

        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            person[i] = new Person(start, end);
        }

        Arrays.sort(person);

        int left = 0;
        int right = 1000000000;
        double answer = 1000000000.0;

        while (left <= right) {
            int mid = (left + right) / 2;
            double max = 0;
            int index = -1;
            for (int i = 0; i<n; i++) {
                if (person[i].start >= mid) {
                    double x = (double) (person[i].start - mid) / (double) person[i].speed;
                    if (x > max) {
                        max = x;
                        index = i;
                    }
                }
                else {
                    double x = (double) (mid - person[i].start) / (double) person[i].speed;
                    if (x > max) {
                        max = x;
                        index = i;
                    }
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