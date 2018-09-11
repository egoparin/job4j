package ru.job4j.loop;

/**
 * Class
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * paint screen
     *
     * @param height
     * @return
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row < weight; row++) {
            for (int column = 0; column < height; column++) {
                if (column <= row) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append("\n");
        }
        return screen.toString();
    }

    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row < weight; row++) {
            for (int column = 0; column < height; column++) {
                if (weight - column - 1 <= row) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append("\n");
        }
        return screen.toString();
    }

    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append("\n");
        }
        return screen.toString();
    }
}