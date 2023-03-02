package algorithm;

import java.util.*;

public class Salinpo {
    static final int MOD = 1_000_000_007;
    static int[] a;
    static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n + 1];
        memo = new int[1 << n];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int result = countWays(0, n, 0);

        System.out.println(result);
    }

    static int countWays(int used, int n, int player) {
        if (used == (1 << n) - 1) {
            return 1;
        }
        if (player > n) {
            return 0;
        }
        if (memo[used] != 0) {
            return memo[used];
        }
        int ways = 0;

        for (int i = 1; i <= n; i++) {
            if (a[i] == 0 && ((used >> (i - 1)) & 1) == 0 && i != player) {
                ways = (ways + countWays(used | (1 << (i - 1)), n, player + 1)) % MOD;
            }
        }

        memo[used] = ways;
        return ways;
    }
}
