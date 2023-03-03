package algorithm;

import java.util.*;
public class LaCrema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double time = 0.0;
            for (int j = l; j < r; j++) {
                if (b[j] < b[j + 1]) {
                    time += b[j] * (j - l + 1);
                } else {
                    time += (double) b[j] / 2 * (j - l + 1);
                    int k = j + 1;
                    while (k <= r && b[k] >= b[j]) {
                        k++;
                    }
                    if (k <= r && b[k] < b[j]) {
                        time += (double) (k - j - 1) / 2 * (j - l + 1);
                        j = k - 1;
                    } else {
                        if (j == r - 1 && b[j + 1] < b[j]) {
                            time += (double) (r - j - 1) / 2 * (j - l + 1);
                            j = r - 1;
                        } else {
                            time += (double) (r - j) / 2 * (j - l + 1);
                            break;
                        }
                    }
                }
            }
            System.out.printf("%.1f\n", time);
        }
    }
}
