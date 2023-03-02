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

        // Calculate cumulative time required to burn matches from the beginning
        double[] cumTime = new double[n];
        cumTime[0] = b[0];
        for (int i = 1; i < n; i++) {
            cumTime[i] = cumTime[i-1] + b[i];
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            double time = cumTime[r] - cumTime[l] + b[l];

            // Adjust time for matches lit from both ends
            for (int i = l; i < r; i++) {
                if (b[i] % 2 == 0) {
                    time -= (double)b[i]/2;
                }
            }
            System.out.printf("%.1f\n", time);
        }
        sc.close();
    }
}
