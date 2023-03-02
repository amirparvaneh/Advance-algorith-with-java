package algorithm;

import java.util.*;

public class Salinpo {
    static int[] visited;
    static int[] colors;
    static boolean[] cycle;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        visited = new int[n];
        colors = new int[n];
        cycle = new boolean[n];
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > 0) {
                a[i]--;
                indegree[a[i]]++;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (dfs(i, a))
                    count++;
            }
        }

        System.out.println(count);
    }

    public static boolean dfs(int i, int[] a) {
        visited[i] = 1;
        int next = a[i];

        if (visited[next] == 0) {
            if (dfs(next, a))
                return true;
        } else if (visited[next] == 1) {
            cycle[i] = true;
            return true;
        }

        visited[i] = 2;
        return false;
    }
}
