package ru.job4j.collections.map.custommap;


import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Custom map.
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 19.03.2019
 */
public class CustomHashMap<K, V> implements Iterable<V> {
    //Buckets
    private Node<K, V>[] hashTable = new Node[16];
    private int size;
    private int modCount;
    private float threshold = hashTable.length * 0.75f;

    public CustomHashMap() {
    }

    public CustomHashMap(int init) {
        hashTable = new Node[init];
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Calculate position, bucket.
     *
     * @param hash   of hashTable.
     * @param length of hashTable.
     * @return index.
     */
    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void arrayDobling() {
        Node<K, V>[] oldArray = hashTable;
        hashTable = new Node[oldArray.length * 2];
        size = 0;
        for (Node<K, V> node : oldArray) {
            if (node != null) {
                while (node.next != null) {
                    node = node.next;
                    insert(node.key, node.value);
                }
                insert(node.key, node.value);
            }
        }
    }

    public boolean insert(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDobling();
        }
        if (key == null) {
            return insertNullKey();
        }
        Node<K, V> newNode = new Node(key, value);
        int index = indexFor(hash(key), hashTable.length);
        if (hashTable[index] == null) {
            return simpleInsert(index, newNode);
        } else {
            return collisionsResolveInsert(index, newNode);
        }
    }

    private boolean insertNullKey() {
        return false;
    }

    private boolean simpleInsert(int index, Node<K, V> newNode) {
        hashTable[index] = newNode;
        modCount++;
        size++;
        return true;
    }

    private boolean collisionsResolveInsert(int index, Node<K, V> newNode) {
        Node<K, V> currentNode = hashTable[index];
        Node<K, V> prevNode = null;
        if (currentNode.hashCode() == newNode.hashCode() && currentNode.equals(newNode)) {
            hashTable[index] = newNode;
            modCount++;
            size++;
            return true;
        }
        while (currentNode != null) {
            if (currentNode.hashCode() == newNode.hashCode() && currentNode.equals(newNode)) {
                newNode.next = currentNode.next;
                prevNode.next = newNode;
                modCount++;
                size++;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (prevNode != null) {
            prevNode.next = newNode;
            modCount++;
            size++;
            return true;
        }
        return false;
    }

    public V get(final K key) {
        int index = indexFor(hash(key), hashTable.length);
        if (index < hashTable.length && hashTable[index] != null) {
            for (int i = index; i < hashTable.length; i++) {
                if (hashTable[i] != null && hashTable[i].key.equals(key)) {
                    return hashTable[i].value;
                }
                Node<K, V> node = hashTable[i];
                if (node != null) {
                    while (node.next != null) {
                        if (node.key.equals(key)) {
                            return node.value;
                        }
                        node = node.next;
                    }
                }
            }
        }
        return null;
    }

    public boolean delete(final K key) {
        int index = indexFor(hash(key), hashTable.length);
        if (hashTable[index] == null) {
            return false;
        }
        Node<K, V> node = hashTable[index];
        if (node.key.equals(key)) {
            if (node.next == null) {
                hashTable[index] = null;
                size--;
                modCount++;
                return true;
            } else {
                hashTable[index] = node.next;
                size--;
                modCount++;
                return true;
            }
        }
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                if (node.next.next != null) {
                    node.next = node.next.next;
                } else {
                    //потерям ссылку на удаляемый объект и gc его зачистит
                    node.next = null;
                }
                size--;
                modCount++;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private static class Node<K, V> {
        //final int hash;
        final K key;
        final V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node(int hash, K key, V value, Node<K, V> next) {
            //this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<K, V> listNext = null;
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                res.append(hashTable[i].key + " " + hashTable[i].value + "\n");
                listNext = hashTable[i];
                while (listNext.next != null) {
                    listNext = listNext.next;
                    res.append(listNext.key + " " + listNext.value + "\n");
                }
            }
        }
        return res.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int expectedModCounter = modCount;
            int counterNext = 0;
            Node<K, V> iterateNode = hashTable[counterNext];
            Node<K, V> lastIterateNode = null;

            @Override
            public boolean hasNext() {
                if (expectedModCounter != modCount) {
                    throw new ConcurrentModificationException();
                }
                //current bucket
                if (counterNext < hashTable.length) {
                    iterateNode = hashTable[counterNext];
                }
                //if this last element.
                if (counterNext == hashTable.length && iterateNode.next == null) {
                    return false;
                }
                //if bucket null, then find not null.
                if (iterateNode == null) {
                    while (iterateNode == null) {
                        iterateNode = hashTable[++counterNext];
                    }
                }
                //if there are collision in bucket.
                if (iterateNode.next != null) {
                    counterNext++;
                    iterateNode = iterateNode.next;
                    lastIterateNode = iterateNode.next.next;
                    return true;
                }
                //last element in node dos't contain next, need check
                if (lastIterateNode != null) {
                    iterateNode = lastIterateNode;
                    lastIterateNode = null;
                } else {
                    return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    return null;
                }
                Node<K, V> currentNode = iterateNode;
                if (iterateNode.next != null) {
                    iterateNode = iterateNode.next;
                } else if (counterNext < hashTable.length) {
                    iterateNode = hashTable[counterNext++];
                }
                return currentNode.value;
            }
        };
    }
}
