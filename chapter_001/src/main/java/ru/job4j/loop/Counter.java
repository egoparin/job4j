package ru.job4j.loop;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**
     * @param start
     * @param finish
     * @return
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result = result + i;
            }
        }
        return result;
    }
}
