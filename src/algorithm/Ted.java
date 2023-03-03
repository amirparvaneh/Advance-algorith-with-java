package algorithm;

import java.util.*;

public class Ted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (seats[x - 1] != 0) {
                x++;
            }
            seats[x - 1] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(seats[i] + " ");
        }
    }
}
