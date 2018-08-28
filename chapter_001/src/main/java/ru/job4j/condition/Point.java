package ru.job4j.condition;

/**
 * Сurrency converter
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param that
     * @return distance
     */

    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;

        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.sqrt(Math.pow(y2 - y1, 2)));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 3);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y1 = " + b.y);

        System.out.println("Distance between points: " + a.distanceTo(b));
    }
}
