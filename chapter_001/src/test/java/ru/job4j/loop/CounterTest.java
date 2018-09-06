package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    Counter counter = new Counter();

    @Test
    public void when1and10Then30() {
        assertThat(counter.add(1, 10), is(30));
    }
}
