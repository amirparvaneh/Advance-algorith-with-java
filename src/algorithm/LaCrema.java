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
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double ans = 0.0;
            if (r - l == 1) {
                ans = 1.0 * (b[l] * b[r]) / (b[l] + b[r]);
            } else {
                for (int i = l; i < r; i++) {
                    ans += 1.0 / b[i];
                }
                ans += 0.5 / b[r-1];
                ans = 1.0 / ans;
            }
            System.out.printf("%.1f\n", ans);
        }
        sc.close();
    }
}
