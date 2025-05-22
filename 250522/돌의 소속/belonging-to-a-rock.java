import java.util.Scanner;

class Rock {
    int a;
    int b;
    int c;

    public Rock(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] stones = new int[n + 1];
        Rock[] sum = new Rock[n+1];
        sum[0] = new Rock(0, 0, 0);
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();

            Rock rock = sum[i-1];

            int a = rock.a;
            int b = rock.b;
            int c = rock.c;

            if (stones[i] == 1) {
                a++;
            }
            else if (stones[i] == 2) {
                b++;
            }
            else {
                c++;
            }
            
            sum[i] = new Rock(a, b, c);
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            Rock rockB = sum[y];
            Rock rockA = sum[x-1];

            int a = rockB.a - rockA.a;
            int b = rockB.b - rockA.b;
            int c = rockB.c - rockA.c;

            System.out.println(a + " " + b + " " + c);
        }
        
    }
}