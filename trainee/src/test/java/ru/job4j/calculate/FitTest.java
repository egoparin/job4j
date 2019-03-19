package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FitTest {
    Fit fit = new Fit();

    @Test
    public void manWeight() {
        double result = fit.manWeight(180D);
        assertThat(result, closeTo(92D, 0.1));
    }

    @Test
    public void womanWeight() {
        double result = fit.womanWeight(170D);
        assertThat(result, closeTo(69D, 0.1));
    }
}
