package ru.job4j.collections.generics.store;

/**
 * @author Oparin Egor (egoparin@gmail.ru)
 * @version $Id$
 * @since 18.01.2019
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
