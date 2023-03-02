package algorithm;

import java.util.*;

public class MagicbyDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of rooms
        int m = input.nextInt(); // number of passages
        int p = input.nextInt(); // number of teleportation permits

        int[][][] dp = new int[n+1][n+1][p+1];
        boolean[][] graph = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph[u][v] = graph[v][u] = true;
        }

        for (int k = 0; k <= p; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (k == 0) {
                        dp[i][j][k] = -1; // no permits left, can't teleport
                    } else {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        for (int x = 1; x <= n; x++) {
                            if (graph[i][x]) {
                                for (int y = 1; y <= n; y++) {
                                    if (graph[j][y]) {
                                        if (x == j && y == i) continue;
                                        int val = dp[x][y][k-1];
                                        if (val != -1) {
                                            dp[i][j][k] = Math.min(dp[i][j][k], val+1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (dp[1][2][p] == -1) {
            System.out.println("Second"); // First magician can't make a move
        } else if (dp[1][2][p] <= 2) {
            System.out.println("First"); // First magician can win in one or two moves
        } else {
            System.out.println("Second"); // First magician can't win in less than three moves
        }
    }
}
