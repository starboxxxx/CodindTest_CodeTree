import java.util.*;

class Weather {
    String date;
    String week;
    String w;

    public Weather(String date, String week, String w) {
        this.date = date;
        this.week = week;
        this.w = w;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Weather[] weather = new Weather[n];

        for (int i = 0; i<n; i++) {
            String date = sc.next();
            String week = sc.next();
            String w = sc.next();

            weather[i] = new Weather(date, week, w);
        }

        int index = 0;

        for (int i = 1; i<n; i++) {
            if (weather[i].w.equals("Rain")) {
                if (index == 0) {
                    index = i;
                }
                else if (weather[i].date.compareTo(weather[index].date) < 0) {
                    index = i;
                }
            }
        }

        System.out.print(weather[index].date + " " + weather[index].week + " " + weather[index].w);
    }
    
}