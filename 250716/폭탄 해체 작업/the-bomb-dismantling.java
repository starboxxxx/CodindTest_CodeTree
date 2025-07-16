import java.util.*;

class Bomb implements Comparable<Bomb> {
    int score;
    int time;

    public Bomb (int score, int time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(Bomb b) {
        if (this.time != b.time) {
            return this.time - b.time;
        }
        return b.score - this.score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[1001];
        Bomb[] bombs = new Bomb[n];
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();

            bombs[i] = new Bomb(score, timeLimit);
        }

        int total = 0;
        Arrays.sort(bombs);
        for (int i = 0; i<n; i++) {
            if (time[bombs[i].time-1] != 1) {
                time[bombs[i].time-1] = 1;
                total += bombs[i].score;
            }
        }

        System.out.print(total);
    }
}