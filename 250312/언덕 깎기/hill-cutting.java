import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = new int[n];

        for (int i = 1; i<=100; i++) {
            int[] maxList = new int[n];
            int maxCount = 0;
            int[] minList = new int[n];
            int minCount = 0;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j<n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxList = new int[n];
                    maxList[j] = 1;
                    maxCount = 1;
                }
                else if (arr[j] == max) {
                    maxList[j] = 1;
                    maxCount++;
                }

                if (arr[j] < min) {
                    min = arr[j];
                    minList = new int[n];
                    minList[j] = 1;
                    minCount = 1;
                }
                else if (arr[j] == min) {
                    minList[j] = 1;
                    minCount++;
                }
            }

            if (max - min<=17) {
                int cost = 0;
                for (int j=0; j<n; j++) {
                    cost += (result[j] * result[j]);
                }
                System.out.print(cost);
                break;
            }
            else if (max - 1 - min <= 17) {
                if (maxCount <= minCount) {
                    for (int k = 0; k<n; k++) {
                        if (maxList[k] == 1) {
                            result[k]++;
                            arr[k]--;
                        }
                    }
                }
                else {
                    for (int k = 0; k<n; k++) {
                        if (minList[k] == 1) {
                            result[k]++;
                            arr[k]++;
                        }
                    }
                }
            }
            else {
                for (int k = 0; k<n; k++) {
                    if (maxList[k] == 1) {
                        result[k]++;
                        arr[k]--;
                    }
                    
                    else if (minList[k] == 1) {
                        result[k]++;
                        arr[k]++;
                    }
                }
            }

        }
    }
}