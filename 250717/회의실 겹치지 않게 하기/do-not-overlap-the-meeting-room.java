import java.util.*;

class Room implements Comparable<Room> {
    int start;
    int end;

    public Room (int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room r) {
        if (this.end != r.end) {
            return this.end - r.end;
        }
        return this.start - r.start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Room[] room = new Room[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            room[i] = new Room(s, e);
        }

        Arrays.sort(room);
        int count = 0;
        int k = 0;
        for (int i = 0; i<n; i++) {
            if (room[i].start >= k) {
                k = room[i].end;
            }
            else {
                count++;
            }
        }

        System.out.print(count);
    }
}