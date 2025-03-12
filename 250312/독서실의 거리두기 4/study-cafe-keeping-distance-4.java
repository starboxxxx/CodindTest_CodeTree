import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = sc.next();

        int[] people = new int[n];

        for (int i = 0; i<n; i++) {
            people[i] = s.charAt(i) - '0';
        }

        int max = 0;

        for (int i = 0; i<n; i++) {
            if (people[i] == 0) {
                people[i] = 1;
                for (int j = i+1; j<n; j++) {
                    if (people[j] == 0) {
                        people[j] = 1;

                        int min = Integer.MAX_VALUE;
                        for (int z = 0; z<n-1; z++) {
                            if (people[z] == 1) {
                                for (int h = z+1; h<n; h++) {
                                    if (people[h] == 1) {
                                        if (h - z < min) {
                                            min = h-z;
                                        }
                                    }
                                }
                            }
                        }
                        if (min > max) {
                            max = min;
                        }
                        people[i] = 0;
                        people[j] = 0;
                    }
                }
            }
        }

        System.out.print(max);
    }
}