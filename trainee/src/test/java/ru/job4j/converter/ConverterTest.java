package ru.job4j.converter;

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
public class ConverterTest {

    Converter conver = new Converter();

    /**
     * Test
     */
    @Test
    public void when60RubToDolThen1() {
        int result = conver.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    public void when70RubToEuroThen1() {
        int result = conver.rubleToEuro(70);
        assertThat(result, is(1));
    }

    @Test
    public void when1DolToRubThen60() {
        int result = conver.dollarToRuble(1);
        assertThat(result, is(60));
    }

    @Test
    public void when1EuroToRubThen70() {
        int result = conver.euroToRuble(1);
        assertThat(result, is(70));
    }
}
