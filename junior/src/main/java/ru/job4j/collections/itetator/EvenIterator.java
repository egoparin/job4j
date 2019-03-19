package ru.job4j.collections.itetator;

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
    private int countNext = 0;
    private int countHasNext = 0;

    public EvenIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        countHasNext++;
        if (indexRow >= values.length) {
            return false;
        }
        if (indexColumn + 1 >= values[indexRow].length) {  //проверка на след.элемнет во внутр. массиве
            indexRow++;
            indexColumn = 0;
        }
        for (int row = indexRow; row <= values.length; row++) {
            if (row >= values.length) {
                return false;
            }
            if (indexColumn + 1 >= values[row].length || row != indexRow) {      //проверка в случае использования hasNext на крайнем внутр. эл-те
                indexColumn = 0;
            }
            if (countHasNext == countNext) {
                nextIndexRow = row;
            } else {
                countHasNext = 0;
                countHasNext = 0;
            }
            for (int column = (indexColumn == 0 && row == 0 || values[row].length == 1) ? indexColumn : ++indexColumn; column < values[row].length; column++) {
                if (values[row][column] % 2 == 0) {
                    if (countHasNext == countNext) {
                        nextIndexColumn = column;
                    } else {
                        countHasNext = 0;
                        countNext = 0;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (hasNext()) {
            countNext++;
            indexRow = nextIndexRow;
            indexColumn = nextIndexColumn;
            return values[nextIndexRow][nextIndexColumn];
        }
        throw new NoSuchElementException();
    }
}
