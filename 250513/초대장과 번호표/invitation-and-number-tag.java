import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g = sc.nextInt();

        ArrayList[] group = new ArrayList[g]; 
        for (int i = 0; i<g; i++) {
            group[i] = new ArrayList<>();
        }

        for (int i = 0; i<g; i++) {
            int k = sc.nextInt();
            for (int j = 0; j<k; j++) {
                group[i].add(sc.nextInt());
            }
        }
        
        HashSet<Integer> set = new HashSet<>();

        set.add(1);

        int count = 1;

        boolean check = true;

        while (check == true) {

            check = false;

            for (int i = 0; i<g; i++) {
                int v = 0;
                int num = 0;
                for (int j = 0; j<group[i].size(); j++) {
                    if (set.contains((int)group[i].get(j))) {
                        v++;
                    }
                    else {
                        num = (int)group[i].get(j);
                    }
                }
                if (v == group[i].size()-1) {
                    set.add(num);
                    count++;
                    check = true;
                }
            }
        }

        System.out.print(count);

    }
}