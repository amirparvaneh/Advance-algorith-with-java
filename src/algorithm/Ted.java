package algorithm;

import java.util.Scanner;

public class Ted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (seats[x - 1] == 0) {
                seats[x - 1] = i + 1;
            } else {
                int j = x;
                while (j <= n && seats[j - 1] != 0) {
                    j++;
                }
                if (j <= n && seats[j - 1] == 0) {
                    seats[j - 1] = i + 1;
                } else {
                    j = 1;
                    while (j < x && seats[j - 1] != 0) {
                        j++;
                    }
                    if (j < x && seats[j - 1] == 0) {
                        seats[j - 1] = i + 1;
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (seats[k] == 0) {
                                seats[k] = i + 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(seats[i] + " ");
        }
    }
}
