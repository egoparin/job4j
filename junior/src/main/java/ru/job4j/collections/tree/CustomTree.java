package ru.job4j.collections.tree;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 06.05.2019
 */
public class CustomTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public boolean isBinaryTree() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> node = data.poll();
            if (node.leaves().size() > 2) {
                return false;
            }
            for (Node<E> child : node.leaves()) {
                data.offer(child);
            }
        }
        return true;
    }

    /**
     * Method for add child in parent.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        if (child == null || parent == null) {
            return false;
        }
        Node<E> parentNode;
        Node<E> childNode = new Node<E>(child);

        if (this.root == null) {
            parentNode = new Node<E>(parent);
            if (!parentNode.eqValue(child)) {
                parentNode.add(childNode);
                this.root = parentNode;
            } else {
                return false;
            }
        } else {
            parentNode = this.findBy(parent).get();
            boolean checkChild = this.findBy(child).isPresent();
            if (!checkChild && parentNode != null && !parentNode.eqValue(child)) {
                parentNode.add(childNode);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> data = new LinkedList<>();
            Node<E> returnNode;

            {
                data.add(root);
            }

            @Override
            public boolean hasNext() {
                return !(data.size() == 0 && returnNode == null);
            }

            @Override
            public E next() {
                returnNode = data.poll();
                if (!hasNext()) {
                    return null;
                }
                for (Node<E> child : returnNode.leaves()) {
                    data.offer(child);
                }
                return returnNode.getValue();
            }
        };
    }
}
