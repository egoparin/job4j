package ru.job4j.collections.list.customstack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 15.02.2019
 */
public class CustomStackTest {

    private CustomStack<Integer> stack = new CustomStack<>();

    @Test
    public void whenPopReturnLastDeleteElement() {
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertThat(6, is(stack.pop()));
        assertThat(5, is(stack.pop()));
    }
}
