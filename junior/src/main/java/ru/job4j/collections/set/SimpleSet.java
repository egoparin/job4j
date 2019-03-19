package ru.job4j.collections.set;

import ru.job4j.collections.list.customarraylist.CustomArrayList;

import java.util.Iterator;


/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 25.02.2019
 */
public class SimpleSet<E> implements Iterable<E> {

    private CustomArrayList<E> simpleList;


    public SimpleSet() {
        simpleList = new CustomArrayList<E>();
    }

    /**
     * Add item in Set.
     *
     * @param item
     */
    public void add(E item) {
        boolean isContains = false;
        for (E value : simpleList) {
            if (item != null && item == value) {
                isContains = true;
            }
        }
        if (!isContains && item != null) {
            simpleList.add(item);
        }

    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
