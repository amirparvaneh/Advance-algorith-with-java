package algorithm;

import java.util.Scanner;

public class FirstTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        int[][] lcs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    lcs[i][j] = 0;
                } else {
                    lcs[i][j] = longestCommonSubstring(s[i], s[j]);
                }
            }
        }
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MIN_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < n - 1; count++) {
            int u = maxKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < n; v++) {
                if (lcs[u][v] > key[v] && !mstSet[v]) {
                    parent[v] = u;
                    key[v] = lcs[u][v];
                }
            }
        }
        int weight = 0;
        for (int i = 1; i < n; i++) {
            weight += lcs[i][parent[i]];
        }
        System.out.println(weight);
    }

    public static int longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    public static int maxKey(int[] key, boolean[] mstSet) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mstSet[i] && key[i] > max) {
                max = key[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
