package algorithm;

import java.util.*;

public class ToTheLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();

        // check if it is possible to reach C without round action
        boolean canReach = false;
        if (ax == cx || ay == cy) {
            if ((ax <= bx && bx <= cx) || (cx <= bx && bx <= ax)) {
                if ((ay <= by && by <= cy) || (cy <= by && by <= ay)) {
                    canReach = true;
                }
            }
        }

        // check if it is possible to reach C with round action
        boolean canRound = false;
        if (!canReach) {
            if ((ax < cx && ay < cy) || (cx < ax && cy < ay)) {
                int dx = ax;
                int dy = cy;
                if ((dx <= bx && bx <= cx) || (cx <= bx && bx <= dx)) {
                    if ((dy <= by && by <= ay) || (ay <= by && by <= dy)) {
                        canRound = true;
                    }
                }
            } else if ((ax < cx && ay > cy) || (cx < ax && cy > ay)) {
                int dx = cx;
                int dy = ay;
                if ((ax <= bx && bx <= dx) || (dx <= bx && bx <= ax)) {
                    if ((dy <= by && by <= cy) || (cy <= by && by <= dy)) {
                        canRound = true;
                    }
                }
            }
        }

        // print the result
        if (canReach || canRound) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
