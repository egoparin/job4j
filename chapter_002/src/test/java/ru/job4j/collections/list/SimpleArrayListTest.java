package ru.job4j.collections.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 28.01.2019
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<Integer>();

    @Before
    @Test
    public void whenAdd() {
        simpleArrayList.add(2);
        simpleArrayList.add(3);
        simpleArrayList.add(4);

        assertThat(simpleArrayList.get(1), is(3));
        assertThat(simpleArrayList.get(0), is(4));
    }

    @Test
    public void whenDelete() {
        assertThat(simpleArrayList.delete(), is(4));
    }

    @Test
    public void whenGetSize() {
        assertThat(simpleArrayList.getSize(), is(3));
    }
}
