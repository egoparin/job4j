package ru.job4j.max;

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
public class MaxTest {

    Max max = new Max();

    /**
     * Test
     *
     */
    @Test
    public void when1and2Then2() {
        assertThat(max.maxNumber(1, 2), is(2));
    }

    @Test
    public void when5and3Then5() {
        assertThat(max.maxNumber(5, 3), is(5));
    }

    @Test
    public void when2and2Then0() {
        assertThat(max.maxNumber(2, 2), is(0));
    }
}
