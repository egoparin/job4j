package ru.job4j.collections.list.detectedloop;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 19.02.2019
 */


public class Node<T> {
    private T value;
    Node<T> next;
    private int id;

    Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    boolean hasCycle(Node first) {

        Node<T> turtle, hare;

        if (first == null) {
            return false;
        }

        turtle = hare = first;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }
}
