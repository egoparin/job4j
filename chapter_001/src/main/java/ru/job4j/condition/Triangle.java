package ru.job4j.condition;

/**
 * Сlass for triangle
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method for calculate 1/2 P triangles.
     * <p>
     * Formule
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab distance between a b
     * @param ac distance betwee a c
     * @param bc distance betwee b c
     * @return semiperimeter.
     */
    public double semiperimeter(double ab, double ac, double bc) {
        return (ab + bc + ac) / 2;
    }

    /**
     * Method for area of triangle
     *
     * @return S or -1, if triangle is not exists.
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.semiperimeter(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }

    /**
     * @param ab distance between a b
     * @param ac distance betwee a c
     * @param bc distance betwee b c
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab < ac + bc) && (ac < ab + bc) && (bc < ab + ac);
    }
}
