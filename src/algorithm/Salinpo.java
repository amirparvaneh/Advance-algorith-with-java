package algorithm;

import java.util.*;

public class Salinpo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] indegrees = new int[n]; // stores the number of incoming edges for each node
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                indegrees[a[i] - 1]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0 && indegrees[i] == 0) {
                // this node is undecided and has no incoming edges
                count++;
            }
        }
        System.out.println(pow(2, count));
    }

    // calculates x to the power of y in O(log y) time
    private static long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }
        return res;
    }
}
