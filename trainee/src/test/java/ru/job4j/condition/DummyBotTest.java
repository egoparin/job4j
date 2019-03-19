package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBotTest {
    DummyBot dummyBot = new DummyBot();

    @Test
    public void whenHello() {
        assertThat(
                dummyBot.answer("Hi, Bot"),
                is("Hi, user")
        );
    }

    @Test
    public void whenBye() {
        assertThat(
                dummyBot.answer("Bye, Bot"),
                is("Bye, user")
        );
    }

    @Test
    public void whenUnknown() {
        assertThat(
                dummyBot.answer("Qwerty"),
                is("This impossible question, ask another")
        );
    }
}
