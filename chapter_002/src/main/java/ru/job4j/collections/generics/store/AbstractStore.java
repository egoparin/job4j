package ru.job4j.collections.generics.store;

import ru.job4j.collections.generics.SimpleArray;

/**
 * @author Oparin Egor (egoparin@gmail.ru)
 * @version $Id$
 * @since 18.01.2019
 */
abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> elements;

    public AbstractStore() {
        elements = new SimpleArray<>(10);
    }

    public AbstractStore(SimpleArray<T> elements) {
        this.elements = elements;
    }

    @Override
    public void add(T model) {
        elements.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = 0;
        for (T b : elements) {
            if (b.getId().equals(id)) {
                this.elements.set(index, model);
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = 0;
        for (T b : elements) {
            if (b.getId().equals(id)) {
                elements.delete(index);
                return true;
            }
            index++;
        }
        return false;
    }


    @Override
    public T findById(String id) {
        for (T b : elements) {
            if (b != null && b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Base b : elements) {
            if (b != null) {
                res.append("[ ").append(b.getId()).append(" ],");
            }
        }
        return res.toString();
    }

    public int size() {
        return elements.size;
    }
}
