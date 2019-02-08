package ru.job4j.collections.list.customlinkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 06.02.2019
 */
public class CustomLinkedList<E> implements SimpleLinkedList<E> {
    private Node<E> firstE;
    private Node<E> lastE;
    private int size = 0;
    private static int modCounter = 0;

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void firstAdd(E element) {
        Node<E> node = new Node<>(element);
        if (firstE != null) {
            firstE.prev = node;
            node.next = firstE;
            firstE = node;

        } else {
            firstE = node;
            lastE = node;
        }
        size++;
        modCounter++;
    }

    @Override
    public void lastAdd(E element) {
        Node<E> node = new Node<>(element);
        if (firstE != null) {
            lastE.next = node;
            node.prev = lastE;
            lastE = node;
        } else {
            firstE = node;
            lastE = node;
        }
        size++;
        modCounter++;
    }

    @Override
    public E getElementByIndex(int counter) {
        if (counter < 0 && counter < size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = firstE;
        for (int i = 0; i < counter; i++) {
            current = current.next;
        }
        return current.value;
    }

    private int getModCounter() {
        return modCounter;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCounter = getModCounter();
            private Node<E> cursorNode = firstE;

            @Override
            public boolean hasNext() {
                if (expectedModCounter != getModCounter()) {
                    throw new ConcurrentModificationException();
                }
                return cursorNode != null;
            }

            @Override
            public E next() {
                Node<E> t = cursorNode;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (cursorNode == null) {
                    throw new NoSuchElementException();
                }
                cursorNode = cursorNode.next;
                return t.value;
            }
        };
    }
}
