package algorithm;

import java.util.*;

public class Salinpo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int taken = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == i+1 || arr[j] == arr[i]) {
                        taken++;
                    }
                }
                if (taken == 0) {
                    arr[i] = i+1;
                    count += solve(arr, i+1);
                    arr[i] = 0;
                }
            }
        }
        System.out.println(count);
    }

    public static int solve(int[] arr, int idx) {
        int count = 0;
        if (idx == arr.length) {
            count++;
        } else {
            if (arr[idx] == 0) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == idx+1 || arr[i] == arr[idx]) {
                        continue;
                    }
                    arr[idx] = i+1;
                    count += solve(arr, idx+1);
                    arr[idx] = 0;
                }
            } else {
                count += solve(arr, idx+1);
            }
        }
        return count;
    }
}
