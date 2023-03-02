package algorithm;

import java.util.Scanner;

public class LaCrema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double time = 0;
            for (int i = l; i < r; i++) {
                time += (double)b[i] / 2;
            }
            time += (double)b[r] / 2;
            System.out.printf("%.1f\n", time);
        }
        sc.close();
    }
}
