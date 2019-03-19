package ru.job4j.collections.generics.store;

/**
 * @author Oparin Egor (egoparin@gmail.ru)
 * @version $Id$
 * @since 18.01.2019
 */
public class User extends Base {

    public User() {
        super(Long.toHexString(Double.doubleToLongBits(Math.random())));
    }
}
