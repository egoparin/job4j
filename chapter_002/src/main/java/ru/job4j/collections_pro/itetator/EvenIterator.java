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
    private int nextIndexRow = 0;
    private int nextIndexColumn = 0;
    private int[][] values;

    public EvenIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        if (indexColumn+1 >= values[indexRow].length){
            indexRow++;
            indexColumn = 0;
        }
        for (int row = indexRow; row <= values.length; row++) {
            nextIndexRow = row;
            for (int column = indexColumn+1; column < values[row].length; column++) {
                if (values[row][column] % 2 == 0) {
                    nextIndexColumn = column;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (hasNext()) {
            return values[indexRow =+ nextIndexRow][indexColumn =+ nextIndexColumn];
        }
        throw new NoSuchElementException();
    }
}
