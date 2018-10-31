package ru.job4j.collections_pro.itetator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConverterIterators {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iterator) {
        return new Iterator<Integer>() {

            private Iterator<Integer> currentIterator;

            private Iterator<Integer> findNext(){
                while (iterator.hasNext()){
                    currentIterator = iterator.next();
                    if (currentIterator.hasNext()){
                        return currentIterator;
                    }
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                if (currentIterator == null || !currentIterator.hasNext()){
                    currentIterator = findNext();
                }
                return (currentIterator != null && currentIterator.hasNext());
            }

            @Override
            public Integer next() throws NoSuchElementException{
                if (currentIterator == null || !currentIterator.hasNext()){
                    currentIterator = findNext();
                }
                return currentIterator.next();
            }
        };
    }
}
