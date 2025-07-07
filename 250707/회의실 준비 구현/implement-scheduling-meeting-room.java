import java.util.*;

class Appointment implements Comparable<Appointment> {
    int start;
    int end;

    public Appointment (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Appointment a) {
        if (this.end != a.end) {
            return this.end - a.end;
        }
        return this.start - a.start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Appointment[] ap = new Appointment[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            ap[i] = new Appointment(s, e);
        }

        Arrays.sort(ap);
        
        int count = 0;
        int current = 0;
        for (int i = 0; i<n; i++) {
            if (ap[i].start >= current) {
                count++;
                current = ap[i].end;
            }
        }

        System.out.print(count);
    }
}