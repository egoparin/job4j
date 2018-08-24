package ru.job4j.calculate;

/**
 * Class for primitive calculation
 *
 * @author Egor Oparin
 * since 0.1
 */
public class Calculator {

    private double result;

    /**
     * Method clean
     * clean result
     * @return result = 0
     */
    public void clean() {
        this.result = 0;
    }

    /**
     * Method division
     * division of two numbers
     *
     * @param first  - first number
     * @param second - second number
     * @return first division second
     */
    public void division(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiply
     * multiply of two numbers
     *
     * @param first  - first number
     * @param second - second number
     * @return first multiply second
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method minus
     * subtraction of two numbers
     *
     * @param first  - first number
     * @param second - second number
     * @return first minus second
     */
    public void minus(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method add
     * summer of two numbers
     *
     * @param first  - first number
     * @param second - second number
     * @return first plus second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method getResult
     * @return current result
     */
    public double getResult() {
        return this.result;
    }
}