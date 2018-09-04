package ru.job4j.condition;

/**
 * Stupid Bot
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {
    /**
     * Answer of questions
     *
     * @param question input question.
     * @return answer
     */

    public String answer(String question) {
        String result = "This impossible question, ask another";
        if ("Hi, Bot".equals(question)) {
            result = "Hi, user";
        } else if ("Bye, Bot".equals(question)) {
            result = "Bye, user";
        }
        return result;
    }
}
