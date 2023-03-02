package algorithm;

import java.util.*;

public class FirstTree {

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return Integer.compare(w, other.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        int[][] weights = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                weights[i][j] = weights[j][i] = lcs(strs[i], strs[j]);
            }
        }
        int maxWeight = findMaxSpanningTree(weights);
        System.out.println(maxWeight);
    }

    public static int lcs(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int maxLen = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    public static int findMaxSpanningTree(int[][] weights) {
        int n = weights.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && weights[i][j] > 0) {
                    adj[i].add(j);
                }
            }
        }
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j : adj[i]) {
                if (group[i] != group[j]) {
                    pq.offer(new Edge(i, j, -weights[i][j]));
                }
            }
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.u, v = e.v, w = -e.w;
            int gu = findGroup(group, u), gv = findGroup(group, v);
            if (gu != gv) {
                group = newGroup(group, gu, gv);
                pq.offer(new Edge(u, v, w));
            }
        }
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            maxWeight += weights[i][group[i]];
        }
        return maxWeight;
    }