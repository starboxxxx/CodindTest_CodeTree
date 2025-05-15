import java.util.*;

class People implements Comparable<People> {
    int start;
    int speed;

    public People (int start, int speed) {
        this.start = start;
        this.speed = speed;
    }

    @Override
    public int compareTo(People p) {
        return this.start - p.start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        
        int[] start = new int[n];
        int[] speed = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            speed[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i<n-1; i++) {

            if (i == n-2) {
                if (start[i] + speed[i] * t < start[i+1] + speed[i+1] * t) {
                    count = count+2;
                }
                else {
                    count++;
                }


            }

            else {
                if (start[i] + speed[i] * t < start[i+1] + speed[i+1] * t) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}