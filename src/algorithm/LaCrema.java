package algorithm;

import java.util.Scanner;

public class LaCrema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            double time = calculateBurnTime(n, b, l, r);
            System.out.printf("%.1f\n", time);
        }

        scanner.close();
    }

    // Calculates the time required for all matches to burn completely from L to R
    private static double calculateBurnTime(int n, int[] b, int l, int r) {
        double time = 0.0;
        for (int i = l; i < r; i++) {
            int burnTime = b[i];
            double halfBurnTime = (double) burnTime / 2.0;
            double totalBurnTime = burnTime;
            if (i == l) {
                totalBurnTime /= 2.0;
            }
            if (i == r - 1) {
                totalBurnTime /= 2.0;
            }
            time += totalBurnTime + (r - i - 1) * halfBurnTime;
        }
        return time;
    }
}
