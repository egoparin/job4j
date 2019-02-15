package ru.job4j.collections.list.customarraylist;

import ru.job4j.collections.list.SimpleList;

import java.util.Iterator;

public class CustomArrayList<E> implements SimpleList<E> {

    private E[] values;
    private static int modCounter = 0;
    private int size;

    CustomArrayList() {
        values = (E[]) new Object[10];
    }

    CustomArrayList(int capacity) {
        values = (E[]) new Object[capacity];
    }

    private void ensureCapacityInternal(int size) {
        try {
            if (this.size + 1 >= size) {
                E[] temp = values;
                values = (E[]) new Object[temp.length * 2];
                System.arraycopy(temp, 0, values, 0, temp.length);
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(values.length);
        values[size++] = e;
        modCounter++;
        return true;
    }

    @Override
    public void delete(int index) {
        //TODO implement method.
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void update(int index, E e) {
        if (index < 0 && index < size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        values[index] = e;
    }

    int getModCounter() {
        return modCounter;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<>(this.values, this);
    }
}
