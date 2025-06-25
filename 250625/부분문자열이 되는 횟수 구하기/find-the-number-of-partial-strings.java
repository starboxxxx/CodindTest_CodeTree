import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        HashMap<Integer, Character> map = new HashMap<>();
        ArrayList<Character> B = new ArrayList<>();

        for (int i = 0; i<first.length(); i++) {
            map.put(i+1, first.charAt(i));
        }

        for (int i = 0; i<second.length(); i++) {
            B.add(second.charAt(i));
        }

        int n = first.length();
        int[] del = new int[n];
        for (int i = 0; i < n; i++) {
            del[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i<=n; i++) {
            set.add(i);
        }

        int count = 0;
        for (int i = 0; i<n; i++) {

            if (map.size() < B.size()) {
                break;
            }

            int left = 0;
            int right = set.last();

            while (left <= right) {

                int mid = (left + right) / 2;
                int target = mid;
                int current = 0;
                while (target <= set.last() && current < B.size()) {
                    
                    if (map.containsKey(target)) {
                        if (map.get(target) == B.get(current)) {
                            current++;
                        }
                    }
                    target++;
                }


                if (current == B.size()) {
                    count++;
                    break;
                }
                else {
                    right = mid-1;
                }
            }

            map.remove(del[i]);
            set.remove(del[i]);
        }

        System.out.print(count);

    }
}