package ru.job4j.collections.list.customstack;

import ru.job4j.collections.list.customlinkedlist.CustomLinkedList;
import java.util.Stack;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 15.02.2019
 */
public class CustomStack<T> {
    private CustomLinkedList<T> list = new CustomLinkedList<>();
    private int size;

    /**
     * Delete return value.
     *
     * @return element value.
     */
    public T pop() {
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
    public void push(T value) {
        list.lastAdd(value);
        size++;
    }

    public int getSize() {
        return this.size;
    }
}
