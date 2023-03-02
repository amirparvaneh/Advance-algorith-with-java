package algorithm;

import java.util.*;

public class NehSi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        int jumps = 0;
        int current = 0;
        int next = 0;
        while (current < n-1) {
            jumps++;
            int maxV = v[current];
            for (int i = current+1; i < n && i <= current + maxV; i++) {
                if (v[i] > v[next]) {
                    next = i;
                }
            }
            if (next == current) {
                System.out.println("-1");
                return;
            }
            current = next;
            next = current;
        }
        System.out.println(jumps);
    }
}
