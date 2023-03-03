package algorithm;

import java.util.Scanner;

public class Ted {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of people
        int[] tickets = new int[n]; // array to store ticket numbers

        for (int i = 0; i < n; i++) {
            tickets[i] = input.nextInt(); // read ticket number for person i
        }

        int[] seats = new int[n]; // array to store seat numbers
        boolean[] taken = new boolean[n + 1]; // boolean array to keep track of taken seats
        for (int i = 0; i < n; i++) {
            int ticket = tickets[i];
            if (!taken[ticket]) {
                seats[i] = ticket;
                taken[ticket] = true;
            } else {
                for (int j = ticket + 1; j <= n; j++) {
                    if (!taken[j]) {
                        seats[i] = j;
                        taken[j] = true;
                        break;
                    }
                }
            }
        }

        // print seat numbers
        for (int i = 0; i < n; i++) {
            System.out.print(seats[i] + " ");
        }
    }
}
