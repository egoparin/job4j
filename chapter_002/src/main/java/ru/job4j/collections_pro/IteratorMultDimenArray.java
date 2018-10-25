package ru.job4j.collections_pro;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 23.10.2018
 */

public class IteratorMultDimenArray {

    private int indexRow = 0;
    private int indexColumn = 0;
    private int lastIndexRow;
    private int lastIndexColumn;
    private final int[][] values;


    public IteratorMultDimenArray(final int[][] values) {
        this.values = values;
        this.lastIndexRow = values.length - 1;
        for (int lastColumn = 0; lastColumn < values[values.length - 1].length; lastColumn++) {
            lastIndexColumn = lastColumn;
        }
    }

    public boolean hasNext() {
        return !(lastIndexRow == indexRow && lastIndexColumn+1 == indexColumn);
    }

    public Object next() {
        if (values[indexRow].length <= indexColumn) {
            indexRow++;
            indexColumn = 0;
        }
        return values[indexRow][indexColumn++];
    }
}
