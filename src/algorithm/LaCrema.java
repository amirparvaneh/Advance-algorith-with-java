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
        double[] prefixSum = new double[n];
        prefixSum[0] = b[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + b[i];
        }
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double leftSum = (l == 0) ? 0 : prefixSum[l - 1];
            double rightSum = prefixSum[r];
            double time = (rightSum - leftSum) / 2.0;
            if (l != r) {
                time += (double)b[l] / 2.0;
                time += (double)b[r] / 2.0;
            } else {
                time += (double)b[l];
            }
            System.out.printf("%.1f\n", time);
        }
        sc.close();
    }
}
