package ru.job4j.collections.map.rulesoverrideehashcode;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Explanation how override hashCode method.
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 04.04.2019
 */
public class TestRule {
    /**
     *  1 - hashCode() must return same integer consistently for the same object.
     *
     *
     *  Contract between equals() and hashCode()
     *  If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
     *
     */

    /**
     * Classic example.
     */
    public class User {
        private String name;
        private int age;
        private String passport;
        @Override
        public int hashCode() {
            int result = 0;
            if(result == 0){
                result = 17; // Aribtrary number.
                result = 31 * result + name.hashCode();
                result = 31 * result + age; // 31 is an odd prime
                result = 31 * result + passport.hashCode();
            }
            return result;
        }
    }
}
