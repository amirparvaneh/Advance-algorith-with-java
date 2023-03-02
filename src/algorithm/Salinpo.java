package algorithm;

import java.util.*;

public class Salinpo {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (a[i] != 0) {
                count[a[i]]++;
            }
        }
        long ans = 1;
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && a[i] == 0) {
                int cnt = 0;
                int j = i;
                while (!vis[j] && a[j] == 0) {
                    vis[j] = true;
                    cnt++;
                    j = a[j] == 0 ? j + 1 : a[j];
                }
                if (a[j] != 0) {
                    count[a[j]] -= cnt;
                    if (count[a[j]] < 0) {
                        System.out.println(0);
                        return;
                    }
                }
                ans = (ans * countWays(cnt)) % MOD;
            }
        }
        System.out.println(ans);
    }

    static long countWays(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        return ans;
    }
}
