import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int count = 0;
        
        for (int i = 0; i<n; i++) {
            for (int j=0; j<n-i; j++) {
                char[] s = new char[i+1];
                boolean isTrue = false;
                for (int z = j; z<=j+i; z++) {
                    s[z-j] = str.charAt(z);
                    
                }

                for (int h = j+i+1; h<n-i; h++) {
                    for (int k = h; k<= h+i; k++) {
                        if (str.charAt(k) != s[k-h]) {
                            break;
                        }

                        if (k == h+i) {
                            count=i+1;
                            isTrue = true;
                        }
                    }
                    if (isTrue) {
                        break;
                    }
                }
                if (isTrue) {
                    break;
                }
            }
        }

        System.out.print(count+1);
    }
}