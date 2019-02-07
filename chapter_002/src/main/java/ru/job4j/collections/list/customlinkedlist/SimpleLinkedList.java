package ru.job4j.collections.list.customlinkedlist;

public interface SimpleLinkedList<E> extends Iterable<E> {

    /**
     * Add new element in start list.
     *
     * @param e
     * @return
     */
    void firstAdd(E e);

    /**
     * Add new element in tail list.
     *
     * @param e
     * @return
     */
    void lastAdd(E e);

    /**
     * Get element by index.
     *
     * @param counter
     * @return
     */
    E getElementByIndex(int counter);
}
