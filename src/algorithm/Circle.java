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
        System.out.printf("%.2f", findSmallestCircle());
        sc.close();
    }

    static double findSmallestCircle() {
        List<Point2D> shuffled = Arrays.asList(points);
        Collections.shuffle(shuffled, new Random());
        Point2D[] c = new Point2D[]{shuffled.get(0)};
        double r = 0;
        for (int i = 1; i < N; i++) {
            Point2D p = shuffled.get(i);
            if (p.distance(c[0]) <= r) {
                continue;
            }
            c = new Point2D[]{p};
            r = 0;
            for (int j = 0; j < i; j++) {
                Point2D q = shuffled.get(j);
                if (q.distance(c[0]) <= r) {
                    continue;
                }
                c = new Point2D[]{new Point2D.Double((p.getX() + q.getX()) / 2, (p.getY() + q.getY()) / 2)};
                r = c[0].distance(p);
                for (int k = 0; k < j; k++) {
                    Point2D r1 = shuffled.get(k);
                    if (r1.distance(c[0]) <= r) {
                        continue;
                    }
                    c = getCircumcenter(p, q, r1);
                    r = c[0].distance(p);
                }
            }
        }
        return r;
    }

    static Point2D[] getCircumcenter(Point2D p, Point2D q, Point2D r) {
        double a = p.getX() - r.getX();
        double b = p.getY() - r.getY();
        double c = q.getX() - r.getX();
        double d = q.getY() - r.getY();
        double e = a * (p.getX() + r.getX()) + b * (p.getY() + r.getY());
        double f = c * (q.getX() + r.getX()) + d * (q.getY() + r.getY());
        double det = 2 * (a * d - b * c);
        double x = (d * e - b * f) / det;
        double y = (a * f - c * e) / det;
        Point2D center = new Point2D.Double(x, y);
        double radius = center.distance(p);
        return new Point2D[]{center, new Point2D.Double(radius, 0)};
    }
}
