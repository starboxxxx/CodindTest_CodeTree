import java.util.*;

class Agent {
    String codeName;
    int score;

    public Agent(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 100;
        String result = "";

        for (int i=1; i<=5; i++) {
            String codeName = sc.next();
            int score = sc.nextInt();

            Agent agent = new Agent(codeName, score);

            if (agent.score < min) {
                result = agent.codeName;
                min = agent.score;

            }
        }

        System.out.print(result + " " + min);
    }
}