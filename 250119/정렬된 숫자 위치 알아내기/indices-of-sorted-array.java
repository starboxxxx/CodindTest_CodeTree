import java.util.*;

class Num {
    int num;
    int index;

    public Num(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int numCache;

        Num[] nums = new Num[N];

        int[] numbers = new int[N];

        for (int i = 0; i<N; i++) {
            numCache = sc.nextInt();
            Num num = new Num(numCache, i);
            nums[i] = num;
        }

        Arrays.sort(nums, new Comparator<Num>() {
            @Override
            public int compare(Num a, Num b) {
                if (a.num == b.num) {
                    return a.index - b.index;
                }
                return a.num - b.num;
            }
        });

        for (int i = 0; i<N; i++) {
            numbers[nums[i].index] = i + 1;
        }

        for (int i = 0; i<N; i++) {
            System.out.print(numbers[i] + " ");
        }


    }
}