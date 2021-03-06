package ru.job4j.max;

/**
 * Max of two numbers
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    /**
     * Max num
     *
     * @param first
     * @param second - input numbers.
     * @return biggest num
     */
    public int maxNumber(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Max num
     */

    public int maxNumber(int first, int second, int third) {
        return this.maxNumber(this.maxNumber(first, second), third);
    }
}
