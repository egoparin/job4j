package ru.job4j.collections.list.customarraylist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;
    private int expectedModCount;
    private CustomArrayList<E> customArrayList = new CustomArrayList<>(0);

    ArrayListIterator(E[] values, CustomArrayList<E> customArrayList) {
        this.values = values;
        this.expectedModCount = customArrayList.getModCounter();
    }

    @Override
    public boolean hasNext() {
        if (expectedModCount != customArrayList.getModCounter()) {
            throw new ConcurrentModificationException();
        }
        return index < values.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
