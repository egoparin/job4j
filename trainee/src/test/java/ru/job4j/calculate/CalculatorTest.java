package ru.job4j.calculate;

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
public class CalculatorTest {

    Calculator calc = new Calculator();

    /**
     * Test
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMinus2On1Then1() {
        calc.minus(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivision4On2Then2() {
        calc.division(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiply2On2Then4() {
        calc.multiply(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenCleanThenResult0() {
        calc.clean();
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }

}
