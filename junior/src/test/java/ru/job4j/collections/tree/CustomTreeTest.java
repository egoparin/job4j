package ru.job4j.collections.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 15.05.2019
 */
public class CustomTreeTest {

    CustomTree<Integer> customTree = new CustomTree<>();

    @Before
    public void init() {
        customTree.add(0, 1);
        customTree.add(1, 2);
        customTree.add(1, 3);
        customTree.add(3, 4);
        customTree.add(2, 5);
        customTree.add(0, 9);
    }

    @Test
    public void whenAddChildToParent() {

        int i = 0;
        int[] result = new int[7];
        for (Integer node : customTree) {
            if (node != null) {
                result[i] = node;
                i++;
            }
        }
        assertArrayEquals(new int[]{0, 1, 9, 2, 3, 5, 4}, result);
    }

    @Test
    public void whenFindThenReturn() {
        assertThat(customTree.findBy(4).get().getValue(), is(new Node<Integer>(4).getValue()));
    }

    @Test//(expected = NoSuchElementException.class)
    public void WhenIterateThen() {
        StringBuilder result = new StringBuilder();
        for (Integer el : customTree) {
            if (el != null) {
                result.append(el + ", ");
            }
        }
        assertThat("0, 1, 9, 2, 3, 5, 4, ", is(result.toString()));
    }

    @Test
    public void WhenIsBinaryThenTrue(){
        CustomTree<Integer> customTreeTest = new CustomTree<>();
        customTreeTest.add(0,1);
        customTreeTest.add(0,2);
        customTreeTest.add(1,3);
        customTreeTest.add(1,4);
        customTreeTest.add(2,5);
        customTreeTest.add(2,6);
        customTreeTest.add(3,7);

        assertTrue(customTreeTest.isBinaryTree());

    }

    @Test
    public void WhenIsBinaryThenFalse(){
        CustomTree<Integer> customTreeTest = new CustomTree<>();
        customTreeTest.add(0,1);
        customTreeTest.add(0,2);
        customTreeTest.add(1,3);
        customTreeTest.add(1,4);
        customTreeTest.add(1,5);
        customTreeTest.add(1,6);

        assertFalse(customTreeTest.isBinaryTree());
    }
}
