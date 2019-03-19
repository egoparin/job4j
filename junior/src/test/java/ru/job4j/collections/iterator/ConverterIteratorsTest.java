package ru.job4j.collections.iterator;

import org.junit.Test;
import ru.job4j.collections.itetator.ConverterIterators;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 30.10.18
 */
public class ConverterIteratorsTest {

    Iterator<Integer> i1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
    Iterator<Integer> i2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
    Iterator<Integer> i3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();

    Iterator<Iterator<Integer>> iterator = Arrays.asList(i1, i2, i3).iterator();
    ConverterIterators iterators = new ConverterIterators();

    Iterator<Integer> result = iterators.convert(iterator);

    /**
     * Test
     */
    @Test
    public void whenGetIteratorOfIteratorsReturnIterator() {
        for (int i = 0; i < 8; i++) {
            result.next();
        }
        assertThat(result.next(), is(9));
    }

}
