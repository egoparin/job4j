package ru.job4j.collections.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 30.10.18
 */
public class SimpleArrayTest {

    SimpleArray<String> simpleArray = new SimpleArray<String>(5);

    @Test
    public void testIterator() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        simpleArray.add(2);
        Iterator<Integer> iterator = simpleArray.iterator();
        iterator.next();
        assertThat(iterator.next(), is(2));
        assertNull(iterator.next());
    }

    /**
     * Test
     */
    @Test
    public void whenAddThenFullArray() {
        simpleArray.add("0");
        simpleArray.add("1");
        simpleArray.add("2");
        simpleArray.add("3");
        simpleArray.add("4");
        simpleArray.add("5");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < simpleArray.size; i++) {
            result.append(simpleArray.get(i));
        }
        assertThat(result.toString(), is("01234"));
    }

    /**
     * Test
     */
    @Test
    public void whenGetThenReturnItem() {
        simpleArray.add("0");
        simpleArray.add("1");
        simpleArray.add("2");
        simpleArray.add("3");
        simpleArray.add("4");
        simpleArray.add("5");
        simpleArray.get(3);
        String result = simpleArray.get(3);
        assertThat(result, is("3"));
    }

    /**
     * Test
     */
    @Test
    public void whenSetThenSetToArray() {
        simpleArray.set(4, "Last");
        String result = simpleArray.get(4);
        assertThat(result, is("Last"));
    }

    /**
     * Test
     */
    @Test
    public void whenDeleteThenDeleteItemEqualNull() {
        simpleArray.set(3, "Middle");
        simpleArray.delete(3);
        String result = simpleArray.get(3);
        assertNull(result);
    }

}

