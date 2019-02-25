package ru.job4j.collections.set;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 25.02.2019
 */
public class SimpleSetTest {
    private SimpleSet<Integer> set = new SimpleSet<>();

    @Before
    public void init() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(2);
    }

    @Test
    public void whenSetReturnUnique() {
        Integer[] dif = new Integer[3];
        int count = 0;
        for (Integer item : set) {
            if (item != null) {
                dif[count++] = item;
            }
        }
        assertThat(dif, is(new Integer[]{1, 2, 3}));
    }
}
