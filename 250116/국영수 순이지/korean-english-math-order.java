import java.util.*;

class Student {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i<n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            Student student = new Student(name, korean, english, math);
            students[i] = student;
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.korean == b.korean) {
                    if (a.english == b.english) {
                        return b.math - a.math;
                    }
                    return b.english - a.english;
                }
                return b.korean - a.korean;
            }
        });

        for (int i = 0; i<n; i++) {
            System.out.println(students[i].name + " " + students[i].korean + " " +
            students[i].english + " " + students[i].math);
        }
    }
}