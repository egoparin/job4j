package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {

    Board board = new Board();
    String ln = System.lineSeparator();

    @Test
    public void when3x3() {
        String result = board.paint(3, 3);
        assertThat(result, is(
                String.format("X X\n X \nX X\n")));
    }

    @Test
    public void when2x5() {
        String result = board.paint(6, 2);
        assertThat(result, is(
                String.format("X X X \n X X X\n")));
    }

}
