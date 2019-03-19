package ru.job4j.loop;

/**
 * Class
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * paint screen
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append("\n");
        }
        return screen.toString();
    }
}
