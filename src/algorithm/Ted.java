package algorithm;

import java.util.*;

public class Ted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] tickets = new int[n];
        for (int i = 0; i < n; i++) {
            tickets[i] = input.nextInt();
        }
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            int x = tickets[i];
            if (seats[x-1] == 0) {
                seats[x-1] = i+1;
            } else {
                int j = x;
                while (j < n && seats[j-1] != 0) {
                    j++;
                }
                seats[j-1] = i+1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(seats[i] + " ");
        }
    }
}
