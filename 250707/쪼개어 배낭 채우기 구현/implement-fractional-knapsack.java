import java.util.*;

class Jewerly implements Comparable<Jewerly>{
    int weight;
    int price;
    double total;

    public Jewerly (int weight, int price, double total) {
        this.weight = weight;
        this.price = price;
        this.total = total;
    }

    @Override
    public int compareTo(Jewerly j) {
        return Double.compare(j.total, this.total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Jewerly[] j = new Jewerly[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            double total = (double) v / (double) w;
            
            j[i] = new Jewerly(w, v, total);
        }

        Arrays.sort(j);

        double result = 0.0;

        for (int i = 0; i<n; i++) {
            if (m - j[i].weight < 0) {
                double weight =  (double) m / (double) j[i].weight;
                result += j[i].price * weight;
                break;
            }
            else if (m - j[i].weight == 0) {
                result += j[i].price;
                break;
            }
            else {
                result += j[i].price;
                m -= j[i].weight;
            }
        }

        System.out.printf("%.3f", result);
    }
}