import java.util.*;

class Promise {
    String secretCode;
    char place;
    int time;

    public Promise(String secretCode, char place, int time) {
        this.secretCode = secretCode;
        this.place = place;
        this.time = time;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String secretCode = sc.next();
        char place = sc.next().charAt(0);
        int time = sc.nextInt();

        Promise promise = new Promise(secretCode, place, time);

        System.out.println("secret code : " + promise.secretCode);
        System.out.println("meeting point : " + promise.place);
        System.out.println("time : " + promise.time);
    }
}