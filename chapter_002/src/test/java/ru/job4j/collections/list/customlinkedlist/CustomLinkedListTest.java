package ru.job4j.collections.list.customlinkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 05.02.2019
 */
public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();

    @Test
    public void whenLastAddThenFillCollectionLastAndIterator() {

        customLinkedList.lastAdd(1);
        customLinkedList.lastAdd(2);
        customLinkedList.lastAdd(3);

        Integer[] dif = new Integer[3];
        int count = 0;

        for (Integer item : customLinkedList) {
            dif[count++] = item;
        }
        assertThat(dif, is(new Integer[]{1, 2, 3}));
    }

    @Test
    public void whenFirstAddThenFillCollectionLastAndIterator() {
        customLinkedList.firstAdd(4);
        customLinkedList.firstAdd(5);
        customLinkedList.firstAdd(6);

        Integer[] dif = new Integer[3];
        int count = 0;

        for (Integer item : customLinkedList) {
            dif[count++] = item;
        }
        assertThat(dif, is(new Integer[]{6, 5, 4}));
    }

    /**
     * First print 1, and throw Exception.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void throwConcurrentModificationException() {
        customLinkedList.lastAdd(1);
        customLinkedList.lastAdd(2);
        customLinkedList.lastAdd(3);

        for (Integer item : customLinkedList) {
            customLinkedList.lastAdd(888);
            System.out.println(item);
        }
    }
}
