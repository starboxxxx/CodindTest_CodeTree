import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashSet<Integer>[] set = new HashSet[n+1];
        int[] a = new int[k];
        int[] b = new int[k];
        int[] arr = new int[n+1];
        int[] ans = new int[n+1];

        for (int i = 1; i<=n; i++) {
            set[i] = new HashSet<Integer>();
        }
        for (int i = 1; i<=n; i++) {
            arr[i] = i;
            set[i].add(i);
            ans[i] = 1;
        }

        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i<3; i++) {
            for (int j = 0; j<k; j++) {
                int tmp = arr[a[j]];
                arr[a[j]] = arr[b[j]];
                arr[b[j]] =  tmp;
                int x = arr[a[j]];
                int y = arr[b[j]];
                if(!set[x].contains(a[j])) {
                    set[x].add(a[j]);
                    ans[x]++;
                }

                if (!set[y].contains(b[j])) {
                    set[y].add(b[j]);
                    ans[y]++;
                }
            }
        }

        for (int i = 1; i<=n; i++) {
            System.out.println(ans[i]);
        }
    }
}