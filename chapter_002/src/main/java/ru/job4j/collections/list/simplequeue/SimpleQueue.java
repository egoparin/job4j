package ru.job4j.collections.list.simplequeue;


import ru.job4j.collections.list.customstack.CustomStack;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 18.02.2019
 */
public class SimpleQueue<T> {
    private CustomStack<T> currentStack = new CustomStack<>();
    private CustomStack<T> helpFulStack = new CustomStack<>();
    private int size = 0;

    /**
     * Delete return first value.
     *
     * @return element value.
     */
    private T pop() {
        T value = list.getLastElement();
        list.removeLast();
        size--;
        return value;
    }

    /**
     * Add item in collection.
     *
     * @param value
     */
    private void push(T value) {

        size++;
    }


}
