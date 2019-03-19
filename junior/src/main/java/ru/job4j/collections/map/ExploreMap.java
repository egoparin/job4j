package ru.job4j.collections.map;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * Testing map.
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 05.03.2019
 */
public class ExploreMap {

    private User user1 = new User("Alex", 1, LocalDate.of(1990, Month.AUGUST, 1));
    private User user2 = new User("Alex", 1, LocalDate.of(1990, Month.AUGUST, 1));
    private User user3 = new User("Jim", 0, LocalDate.of(1992, Month.JANUARY, 23));

    private static Map<User, String> map = new HashMap<>();

    private void testMap() {
        System.out.println(user1.equals(user2));
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }

    /**
     * Don't modified equals and hashCode;
     * {ru.job4j.collections.map.User@6bc7c054=second, ru.job4j.collections.map.User@75b84c92=first}
     */
    /*
     * Для текущей HaspMap в качестве ключа используется класс User, а в качестве значения просто строка.
     * По умолччанию должно создаться 16 корзин. Через метод put, в Map добавили 2 записи (ключ-значение).
     * Соответсвенно, т.к ключи разные, то они и находятся в разных корзинах. Распределились по значению hashCode.
     *  [1*]     [2]     [3*]     [4]     [5]     [6]     [7]     [8]     [9]     [10]    [11]    [12]    [13]    [14]    [15]    [16]
     *   |       |        |        |       |       |       |       |       |        |       |       |       |       |       |       |
     *  first           second
     */

    /**
     * Modified hashCode;
     * {ru.job4j.collections.map.User@6bc7c054=second, ru.job4j.collections.map.User@75b84c92=first}
     */
    /* Метод put сравнивает сначала объект по hashCode, затем если они равны то по equals.
     * Соответсвенно, т.к контракт equals и hashCode не выполняется, то объекты не равны, но в этот раз лежать они будут
     * в одной корзине, так как возникает коллизия из-за одинакового hashCode, в результате first будет иметь ссылку next на объект second.
     * Для успешного поиска объекта в хэш-таблице помимо сравнения хэш-значений ключа используется также определение логического равенства ключа с искомым объектом.
     * Т. е. без переопределения метода equals никак не получится обойтись.
     * [1*]     [2]     [3*]     [4]     [5]     [6]     [7]     [8]     [9]     [10]    [11]    [12]    [13]    [14]    [15]    [16]
     *   |       |        |        |       |       |       |       |       |        |       |       |       |       |       |       |
     *  first
     *   |
     *  second
     */

    /**
     * Modified equals;
     * {ru.job4j.collections.map.User@6bc7c054=second, ru.job4j.collections.map.User@75b84c92=first}
     */
    /* Метод put сравнивает сначала объект по hashCode, затем если они равны то по equals.
     * Очевидно, что помещаемый и искомый объект — это два разных объекта, хотя они и являются логически равными.
     * Но, т.к. они имеют разное хэш-значение, потому что мы нарушили контракт, можно сказать, что мы потеряли свой объект где-то в недрах хэш-таблицы.
     * [1*]     [2]     [3*]     [4]     [5]     [6]     [7]     [8]     [9]     [10]    [11]    [12]    [13]    [14]    [15]    [16]
     *   |       |        |        |       |       |       |       |       |        |       |       |       |       |       |       |
     *  first  second
     */

    /**
     * Modified equals and hashCode;
     * {ru.job4j.collections.map.User@3c69984=second}
     */
    /* Метод put сравнивает сначала объект по hashCode, затем если они равны то по equals.
     * При выполнии побоих условий сейчас, с учетом что переопределен hashCode, попадут они в одну корзину,
     * затем сравниться по перепределенному equals и перезапишет объект.
     * [1*]     [2]     [3*]     [4]     [5]     [6]     [7]     [8]     [9]     [10]    [11]    [12]    [13]    [14]    [15]    [16]
     *   |       |        |        |       |       |       |       |       |        |       |       |       |       |       |       |
     *  second
     */

    public static void main(String[] args) {
        ExploreMap exploreMap = new ExploreMap();
        exploreMap.testMap();
    }
}
