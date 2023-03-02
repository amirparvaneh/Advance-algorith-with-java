package algorithm;
import java.util.Scanner;

public class Circle {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point(x, y);
        }
        double minRadius = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    Point p1 = points[i];
                    Point p2 = points[j];
                    Point p3 = points[k];
                    double radius = getRadius(p1, p2, p3);
                    int count = 3;
                    for (int l = 0; l < n; l++) {
                        if (l != i && l != j && l != k) {
                            Point p = points[l];
                            if (inCircle(p1, p2, p3, p)) {
                                count++;
                            }
                        }
                    }
                    if (count >= m && radius < minRadius) {
                        minRadius = radius;
                    }
                }
            }
        }

        System.out.printf("%.2f", minRadius);
    }

    static double getRadius(Point p1, Point p2, Point p3) {
        double a = dist(p1, p2);
        double b = dist(p2, p3);
        double c = dist(p3, p1);
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return a*b*c / (4*area);
    }

    static double dist(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    static boolean inCircle(Point p1, Point p2, Point p3, Point p) {
        double radius = getRadius(p1, p2, p3);
        double dist = dist(p, new Point((p1.x+p2.x+p3.x)/3, (p1.y+p2.y+p3.y)/3));
        return dist <= radius;
    }
}
