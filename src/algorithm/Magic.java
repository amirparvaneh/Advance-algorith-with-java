package algorithm;

import java.util.*;

public class Magic {
    static int n, m, p;
    static int[][] graph;
    static boolean[][] visited;
    static int[] teleports;
    static int[] distances1;
    static int[] distances2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
        graph = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        teleports = new int[]{p, p};
        distances1 = new int[n+1];
        distances2 = new int[n+1];

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u][v] = graph[v][u] = 1;
        }

        bfs(1, distances1);
        bfs(2, distances2);

        if (distances1[2] <= 2) {
            System.out.println("First");
            return;
        }

        boolean possible = false;
        for (int i = 1; i <= n && !possible; i++) {
            for (int j = i+1; j <= n && !possible; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = graph[j][i] = 1;
                    bfs(2, distances2);
                    if (distances1[2] <= 2) {
                        System.out.println("First");
                        possible = true;
                    }
                    graph[i][j] = graph[j][i] = 0;
                }
            }
        }

        if (!possible) {
            System.out.println("Second");
        }
    }

    static void bfs(int s, int[] distances) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[s] = 0;
        visited[s][s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 1; v <= n; v++) {
                if (graph[u][v] == 1 && !visited[s][v]) {
                    visited[s][v] = true;
                    distances[v] = distances[u] + 1;
                    queue.offer(v);
                }
            }

            if (teleports[s-1] > 0) {
                for (int v = 1; v <= n; v++) {
                    if (v != u && !visited[s][v]) {
                        visited[s][v] = true;
                        distances[v] = distances[u] + 1;
                        teleports[s-1]--;
                        queue.offer(v);
                        break;
                    }
                }
            }
        }
    }
}
