package algorithm;

import java.util.*;

public class TedByDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] tickets = new int[n];
        for (int i = 0; i < n; i++) {
            tickets[i] = input.nextInt();
        }
        int[] seats = new int[n];
        Arrays.fill(seats, -1); // initialize seats array with -1
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i+1;
        }
        for (int i = n-1; i >= 0; i--) {
            int x = tickets[i];
            if (dp[x-1] <= n) {
                seats[dp[x-1]-1] = i+1;
                dp[x-1]++; // increment smallest unassigned seat number starting from seat x
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(seats[i] + " ");
        }
    }
}