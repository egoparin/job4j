package ru.job4j.collectionsPro.generics;

/*
 В этом задании необходимо сделать универсальную обертку над массивом.
 Создать класс
 public class SimpleArray<T>
 Добавить методы.
 add(T model),
 set(int index, T model),
 delete(int index),
 get(int index);
 Так же, добавьте Iterable<T>.
 Объект должен принимать количество ячеек. Структура не должна быть динамической. Если идет переполнение надо выкинуть ошибку.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 02.12.2018
 */
public class SimpleArray<T> implements Iterable<T> {

    private final T[] array;
    public final int size;
    private int indexPosition = 0;

    @SuppressWarnings("unchecked")
    public SimpleArray() {
        this.size = 5;
        this.array = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public SimpleArray(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    public void add(T model) throws IndexOutOfBoundsException {
        if (iterator().hasNext()) {
            this.array[indexPosition++] = model;
        }
    }

    public void set(int index, T model) throws IndexOutOfBoundsException {
        this.array[index] = model;
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        array[index] = null;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        int current = 0;

        public boolean hasNext() {
            if (current < SimpleArray.this.array.length) {
                return true;
            } else {
                return false;
            }
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[current++];
        }
    }

}
