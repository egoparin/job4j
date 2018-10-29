package ru.job4j.collerctions_pro.iterator;

import org.junit.Test;
import ru.job4j.collections_pro.itetator.EvenIterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 29.10.2018
 */
public class EvenIteratorTest {

    private int array[][] = {{1, 2, 10}, {3, 4, 5}, {7, 9, 6, 4}, {8}};
    private EvenIterator it = new EvenIterator(array);

    /**
     * Test
     */
    @Test
    public void whenGetNextCallNextEven() {
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(10));
    }

    /**
     * Test
     */
    @Test
    public void whenCheckNextReturnResultEven() {

        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));

        result = it.hasNext();
        assertThat(result, is(true));

    }
}
