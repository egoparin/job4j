package ru.job4j.calculate;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Fit {

    final private double coef = 1.15;

    /**
     * Perfect weight for man
     *
     * @param height return weight
     */
    public double manWeight(double height) {
        return (height - 100) * coef;
    }

    /**
     * Perfect weight for woman
     *
     * @param height return weight
     */
    public double womanWeight(double height) {
        return (height - 110) * coef;
    }
}
