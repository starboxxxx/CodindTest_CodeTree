import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        String[][] a = new String[R][C];

        for (int i = 0; i<R; i++) {
            for (int j = 0; j<C; j++) {
                a[i][j] = sc.next();
            }
        }

        String current = a[0][0];
        int count = 0;

        for (int i = 1; i<=R-3; i++) {
            for (int j = 1; j<=C-3; j++) {
                if (!a[i][j].equals(current)) {
                    for (int z = i+1; z<=R-2; z++) {
                        for (int k = j+1; k<=C-2; k++) {
                            if (a[z][k].equals(current)) {
                                count++;
                                System.out.print(count);
                            }
                        }
                    }
                }
            }
        }

        System.out.print(count);
    }
}