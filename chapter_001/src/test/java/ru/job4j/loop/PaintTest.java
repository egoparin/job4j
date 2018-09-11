package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    Paint paint = new Paint();

    @Test
    public void whenPyramid4() {
        String result = paint.pyramid(4);
        System.out.println(result);
        assertThat(result, is("   ^   \n"
                +
                "  ^^^  \n"
                +
                " ^^^^^ \n"
                +
                "^^^^^^^\n"));
    }

    @Test
    public void whenPyramid4Left() {
        String result = paint.leftTrl(4);
        System.out.println(result);
        assertThat(result,
                is("   ^\n"
                        +
                        "  ^^\n"
                        +
                        " ^^^\n"
                        +
                        "^^^^\n"));

    }

    @Test
    public void whenPyramid4Right() {
        String result = paint.rightTrl(4);
        System.out.println(result);
        assertThat(result,
                is("^   \n"
                        +
                        "^^  \n"
                        +
                        "^^^ \n"
                        +
                        "^^^^\n"));
    }
}
