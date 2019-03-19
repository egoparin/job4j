package ru.job4j.converter;


/**
 * Сurrency converter
 *
 * @author Egor Oparin
 * since 0.1
 */
public class Converter {

    private final int dollar = 60;
    private final int euro = 70;

    /**
     * Convert ruble to euro
     *
     * @param value value of ruble
     */
    public int rubleToEuro(int value) {
        return value / euro;
    }

    /**
     * Convert ruble to dollar
     *
     * @param value value of ruble
     */
    public int rubleToDollar(int value) {
        return value / dollar;
    }

    /**
     * Convert ruble to euro
     *
     * @param value value of ruble
     */
    public int euroToRuble(int value) {
        return value * euro;
    }

    /**
     * Convert ruble to dollar
     *
     * @param value value of ruble
     */
    public int dollarToRuble(int value) {
        return value * dollar;
    }
}
