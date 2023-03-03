package algorithm;

import java.util.*;
import java.awt.geom.*;

public class Circle {
    static int N, M;
    static Point2D[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point2D.Double(x, y);
        }
        System.out.printf("%.2f", smallestCircle());
        sc.close();
    }

    static double smallestCircle() {
        double radius = Double.POSITIVE_INFINITY;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Point2D center = new Point2D.Double((points[i].getX() + points[j].getX()) / 2,
                        (points[i].getY() + points[j].getY()) / 2);
                double r = center.distance(points[i]);
                if (r >= radius) {
                    continue;
                }
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (points[k].distance(center) <= r) {
                        count++;
                        if (count >= M) {
                            radius = r;
                            break;
                        }
                    }
                }
            }
        }
        return radius;
    }
}
