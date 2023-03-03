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

        int ans = -1;

        for (int i = 0; i < n - 1; i++) {
            int min = v[i];
            int max = v[i + 1];
            boolean valid = true;

            for (int j = i + 1; j < n - 1; j++) {
                if (v[j] < min) {
                    min = v[j];
                }

                if (v[j + 1] > max) {
                    max = v[j + 1];
                }

                if (min + max == j - i + 2) {
                    ans = -1;
                    break;
                }
            }

            if (ans == -1) {
                break;
            }
        }

        System.out.println(ans);
    }
}
