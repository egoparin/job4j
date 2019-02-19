package ru.job4j.collections.list.simplequeue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 19.02.2019
 */
public class SimpleQueueTest {

    private SimpleQueue<Integer> queue = new SimpleQueue<>();

    @Before
    public void init() {
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
    }

    @Test
    public void whenPopReturnFirstDeleteElement() {
        assertThat(3, is(queue.pop()));
        assertThat(4, is(queue.pop()));
        assertThat(5, is(queue.pop()));
    }
}
