package algorithm;

import java.util.*;

public class NehSi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minV = v[i];
            int maxV = v[i];
            for (int j = i; j >= 1; j--) {
                minV = Math.min(minV, v[j-1]);
                maxV = Math.max(maxV, v[j-1]);
                if (maxV - minV > i - j + 1) break;
                dp[i] = Math.min(dp[i], dp[j-1] + 1);
            }
        }
        System.out.println(dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1]);
    }
}
