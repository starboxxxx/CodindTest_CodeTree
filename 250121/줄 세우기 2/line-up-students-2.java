import java.util.*;
class Student implements Comparable<Student>{

    int height;
    int weight;
    int k;

    public Student(int height, int weight, int k) {
        this.height = height;
        this.weight = weight;
        this.k = k;
    }

    @Override
    public int compareTo(Student student) {
        if (this.height == student.height) {
            return student.weight - this.weight;
        }
        return this.height - student.height;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Student[] students = new Student[N];

        for (int i = 0; i<N; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            int k = i+1;
            students[i] = new Student(height, weight, k);
        }

        Arrays.sort(students);

        for (int i = 0; i<N; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].k);
        }
    }
}