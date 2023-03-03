package algorithm;

import java.util.Scanner;

public class LaCrema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            double sum = 0;
            for (int j = l; j < r; j++) {
                if (b[j] < b[j + 1]) {
                    sum += 0.5 * b[j];
                    for (int k = j + 1; k <= r && b[k] >= b[j]; k++) {
                        sum += 0.5 * b[j];
                    }
                } else {
                    sum += 0.5 * b[j + 1];
                    for (int k = j; k >= l && b[k] >= b[j + 1]; k--) {
                        sum += 0.5 * b[j + 1];
                    }
                }
            }
            System.out.printf("%.1f\n", sum);
        }
    }
}
