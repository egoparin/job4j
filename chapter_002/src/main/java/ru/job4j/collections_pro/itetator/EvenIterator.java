package ru.job4j.collections_pro.itetator;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 26.10.2018
 */
public class EvenIterator implements Iterator {

    private int indexRow = 0;
    private int indexColumn = 0;
    private int nextIndexRow;
    private int nextIndexColumn;
    private int[][] values;

    public EvenIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int row = indexRow; row <= values.length; row++) {
            for (int column = indexColumn + 1; column < values[row].length; column++) {
                if (values[row][column] % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object next() throws NoSuchElementException {

        rowLoop:
        for (int row = indexRow; row <= values.length; row++) {
            for (int column = indexColumn + 1; column < values[row].length; column++) {
                if (values[row][column] % 2 == 0) {
                    nextIndexRow = row;
                    nextIndexColumn = column;
                    break rowLoop;
                }
            }
        }
        if (hasNext()) {
            indexRow = nextIndexRow;
            indexColumn = nextIndexColumn;
        }
        return values[indexRow][indexColumn];
    }
}
