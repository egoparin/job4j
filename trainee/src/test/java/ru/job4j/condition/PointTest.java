package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    Point a = new Point(0, 1);
    Point b = new Point(2, 1);

    @Test
    public void when1Point01and2Point21then2() {
        double result = a.distanceTo(b);
        assertThat(result, is(2D));
    }
}
