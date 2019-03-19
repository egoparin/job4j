package ru.job4j.collections.list.customarraylist;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 05.02.2019
 */
public class CustomArrayListTest {

    CustomArrayList<Integer> customArrayList = new CustomArrayList<>(3);

    @Test
    public void whenAddThenFillCollectionAndIterator() {

        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(55); //extend collection 6

        Integer[] dif = new Integer[6];
        int count = 0;
        for (Integer item : customArrayList) {
            dif[count++] = item;
        }

        assertThat(dif, is(new Integer[]{1, 2, 3, 55, null, null}));
    }

    @Test
    public void whenGetReturnElement() {
        customArrayList.add(4);
        customArrayList.add(5);
        assertThat(customArrayList.get(1), is(5));
    }

    /**
     * First print 1, and throw Exception.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void throwConcurrentModificationException() {
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        for (Integer item : customArrayList) {
            customArrayList.add(888);
            System.out.println(item);
        }
    }
}

