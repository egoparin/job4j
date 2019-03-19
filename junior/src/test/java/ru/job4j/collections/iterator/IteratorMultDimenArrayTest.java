package ru.job4j.collections.iterator;

import org.junit.Test;
import ru.job4j.collections.itetator.IteratorMultDimenArray;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class IteratorMultDimenArrayTest {

    private int[][] array = {{1, 2}, {3, 4, 5}, {7, 9, 6, 4}, {8}};
    private IteratorMultDimenArray it = new IteratorMultDimenArray(array);

    /**
     * Test
     */
    @Test
    public void whenGetNextCallShouldStraightAhead() {
        it.next();
        int result = (Integer) it.next();
        assertThat(result, is(2));
    }

    /**
     * Test
     */
    @Test
    public void whenCheckNextReturnResult() {

        it.next();
        boolean result = it.hasNext();
        assertThat(result, is(true));

        for (int i = 0; i < 9; i++) {
            it.next();
        }
        result = it.hasNext();
        assertThat(result, is(false));

    }
}
