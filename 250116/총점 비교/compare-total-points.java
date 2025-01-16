import java.util.*;

class Student {
    String name;
    int score1;
    int score2;
    int score3;
    int total;

    public Student(String name, int score1, int score2, int score3, int total) {
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.total = total;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        int total = 0;
        for (int i = 0; i<n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            total += score1;
            total += score2;
            total += score3;
            Student student = new Student(name, score1, score2, score3, total);
            students[i] = student;
            total = 0;
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.total - b.total;
            }
        });

        for (int i = 0; i<n; i++) {
            System.out.println(students[i].name + " " + students[i].score1
            + " " + students[i].score2 + " " + students[i].score3);
        }
    }
}