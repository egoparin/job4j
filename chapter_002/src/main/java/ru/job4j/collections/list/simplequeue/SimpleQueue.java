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
    public T pop() {
        if (helpFulStack.getSize() == 0) {
            while (currentStack.getSize() != 0) {
                helpFulStack.push(currentStack.pop());
            }
        }
        size--;
        return helpFulStack.pop();
    }

    /**
     * Add item in collection.
     *
     * @param value
     */
    public void push(T value) {
        size++;
        this.currentStack.push(value);
    }


}
