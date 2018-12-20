package ru.job4j.collectionsPro.itetator;

import java.util.Iterator;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 23.10.2018
 */

public class IteratorMultDimenArray implements Iterator<Integer> {

    private int indexRow = 0;
    private int indexColumn = 0;
    private final int[][] values;


    public IteratorMultDimenArray(final int[][] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return !(values.length - 1 == indexRow && values[values.length - 1].length == indexColumn);
    }

    public Integer next() {
        if (values[indexRow].length <= indexColumn) {
            indexRow++;
            indexColumn = 0;
        }
        return values[indexRow][indexColumn++];
    }
}
