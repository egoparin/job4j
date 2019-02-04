package ru.job4j.collections.list;


/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 28.01.2019
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Method add new data in list.
     *
     * @param data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Method delete first element from collection.
     */
    public E delete() {
        Node<E> result = this.first;
        this.first = result.next;
        size--;
        return result.data;
    }

    /**
     * Method to get element at index.
     *
     * @param index
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Method to get size collection.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Inner class for store data.
     *
     * @param <E>
     */
    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;

        }
    }
}
