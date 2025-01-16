import java.util.*;

class Student implements Comparable<Student> {

    int height;
    int weight;
    int num;

    public Student(int height, int weight, int num) {
        this.height = height;
        this.weight = weight;
        this.num = num;
    }

    @Override
    public int compareTo(Student student) {
        if (student.height == this.height) {
            if (student.weight == this.weight) {
                return this.num - student.num;
            }
            return student.weight - this.weight;
        }
        return student.height - this.height;
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
            int num = i+1;

            Student student = new Student(height, weight, num);
            students[i] = student;
        }

        Arrays.sort(students);

        for (int i = 0; i<N; i++) {
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].num);
        }
    }
}