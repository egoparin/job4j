package ru.job4j.collections.generics.store;


/**
 * @author Oparin Egor (egoparin@gmail.ru)
 * @version $Id$
 * @since 18.01.2019
 */
interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
