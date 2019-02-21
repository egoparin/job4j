package ru.job4j.collections.list.detectedloop;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 21.02.2019
 */
public class NodeTest {


    Node first = new Node(1);
    Node two = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    @Test
    public void whenLoopReturnTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(first.hasCycle(first));
    }

    @Test
    public void whenNotLoopReturnFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertFalse(first.hasCycle(first));
    }
}

