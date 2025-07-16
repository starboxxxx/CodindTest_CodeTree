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
        if (b.score != this.score) {
            return b.score - this.score;
        }
        return b.time - this.time;
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
        Arrays.sort(bombs);

        int total = 0;
        for (int i = 0; i<n; i++) {
            for (int j = bombs[i].time-1; j>=0; j--) {
                if (time[j] == 0) {
                    time[j] = 1;
                    total += bombs[i].score;
                    break;
                }
            }
        }

        System.out.print(total);
    }
}