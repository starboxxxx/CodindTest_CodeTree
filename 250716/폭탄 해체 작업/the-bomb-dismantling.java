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
        int[] time = new int[1000];
        Bomb[] bombs = new Bomb[n];
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();

            bombs[i] = new Bomb(score, timeLimit);
        }

        int total = 0;
        int current = 0;
        Arrays.sort(bombs);
        for (int i = 0; i<n; i++) {
            if (bombs[i].time > current && time[current] != 1) {
                time[current] = 1;
                total += bombs[i].score;
                current++;
            }
        }

        System.out.print(total);
    }
}