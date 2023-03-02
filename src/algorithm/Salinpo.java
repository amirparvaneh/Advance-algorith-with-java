package algorithm;

import java.util.*;

public class Salinpo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int undecided = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                undecided++;
            }
        }

        long validStates = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                long availableChoices = undecided - 1;
                if (i == 0 || a[i-1] != i) {
                    availableChoices--;
                }
                if (i == n-1 || a[i+1] != i+2) {
                    availableChoices--;
                }
                validStates *= availableChoices;
                undecided--;
            }
        }

        System.out.println(validStates);
    }
}
