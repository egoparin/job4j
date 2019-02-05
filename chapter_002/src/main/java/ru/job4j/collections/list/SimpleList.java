package ru.job4j.collections.list;

public interface SimpleList<E> extends Iterable<E> {
    /**
     * Add new element.
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * Delete element, using index.
     * @param index
     */
    void delete(int index);

    /**
     * Get element by index.
     * @param index
     * @return
     */
    E get(int index);

    /**
     * Get size of collection.
     * @return
     */
    int size();

    /**
     * Replace element in collection
     * @param index
     * @param e
     */
    void update(int index, E e);
}
