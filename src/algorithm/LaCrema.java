package algorithm;

import java.util.*;

public class LaCrema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        double[] dp = new double[n];
        dp[0] = b[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + b[i];
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i-1] + b[i]/2.0);
        }
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.min(dp[i], dp[i+1] + b[i]/2.0);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double time = dp[r] - dp[l] + b[l]/2.0;
            System.out.printf("%.1f%n", time);
        }
    }
}
