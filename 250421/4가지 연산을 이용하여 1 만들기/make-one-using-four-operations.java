import java.util.*;

class Num {
    int currentNum;
    int count;

    public Num(int currentNum, int count) {
        this.currentNum = currentNum;
        this.count = count;
    }
}

public class Main {
    public static int n;
    public static Queue<Num> q = new LinkedList<>();
    public static int[] visited = new int[10000000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        q.add(new Num(n, 0));

        System.out.print(bfs());
    }

    public static int bfs() {
        Num num = new Num(0, 0);
        int currentNum=0;
        int count = 0;
        while(!q.isEmpty()) {
            num = q.poll();
            currentNum = num.currentNum;
            count = num.count;

            if (currentNum == 1) {
                break;
            }

            if (visited[currentNum + 1] == 0) {
                q.add(new Num(currentNum+1, count+1));
                visited[currentNum+1] = 1;
            }

            if (visited[currentNum - 1] == 0) {
                q.add(new Num(currentNum-1, count+1));
                visited[currentNum-1] = 1;
            }

            if (currentNum % 2 == 0 && visited[currentNum/2] == 0) {
                q.add(new Num(currentNum / 2, count+1));
                visited[currentNum/2] = 1;
            }

            if (currentNum % 3 == 0 && visited[currentNum/3] == 0) {
                q.add(new Num(currentNum / 3, count+1));
                visited[currentNum/3] = 1;
            }
        }

        return count;
    }
}