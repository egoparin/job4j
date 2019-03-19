package ru.job4j.collections.iterator;

import org.junit.Test;
import ru.job4j.collections.itetator.EvenIterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 29.10.2018
 */
public class EvenIteratorTest {

    private int[][] array = {{1, 2, 10}, {3, 8, 5}, {7, 9, 6, 4}, {8}};
    private EvenIterator it = new EvenIterator(array);

    /**
     * Test
     */
    @Test
    public void whenGetNextCallNextEven() {

        it.next();
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(8));
    }

    /**
     * Test
     */
    @Test
    public void whenCheckNextReturnResultEven() {

        System.out.println(it.next()); //2
        System.out.println(it.next()); //10
        System.out.println(it.next()); //8
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        assertTrue(it.hasNext());
        System.out.println(it.next()); //6
        System.out.println(it.next()); //4
        System.out.println(it.next()); //8
        assertFalse(it.hasNext());
    }
}
