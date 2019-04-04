package ru.job4j.collections.map.rulesoverrideequals;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Explanation how override equals method.
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 03.04.2019
 */
public class TestRules {

    /**
     * Reflexive:  x.equals(x) == true , an object must equal to itself.
     * Symmetry:   if(x.equals(y)==true) then y.equals(x) == true.
     * Transitive: if x.equals(y) and y.equals(z); then x.equals(z)
     * Consistent: if x.equals(y)==true and no value is modified, then it’s always true for every call
     * For any non-null object x, x.equals(null)==false
     */

    @Test
    public void testReflexive() {
        Screen screen = new Screen("Z001", 1233);
        assertTrue(screen.equals(screen));
    }

    @Test
    public void testSymmetry() {
        Screen screen1 = new Screen("Z001", 1233);
        Screen screen2 = new Screen("Z001", 1233);
        assertTrue(screen1.equals(screen2));
        assertTrue(screen2.equals(screen1));
    }

    @Test
    public void testTransitive() {
        Screen screen1 = new Screen("Z001", 1233);
        Screen screen2 = new Screen("Z001", 1233);
        Screen screen3 = new Screen("Z001", 1233);
        assertTrue(screen1.equals(screen2));
        assertTrue(screen2.equals(screen3));
        assertTrue(screen3.equals(screen1));
    }

    //Special violation

    /**
     * Second equals violet symmetry.
     * A extend B => b instanceof A = true, but a instanceof B = false
     */
    @Test
    public void testSymmetryTV() {
        Screen screen = new Screen("A001", 1);
        TV tv = new TV("A001", 1, false);
        assertTrue(screen.equals(tv));
        assertFalse(tv.equals(screen));
    }

    /**
     * It's ok, because equals() of SmartPhone contain special condition.
     * But this failed the transitive test.
     * “There is no way to extend an instantiable class
     * and add a value component while preserving the equals contract,
     * unless you are willing to forgo the benefits of object-oriented abstraction.”
     * ! “Favor composition over inheritance.”
     */
    @Test
    public void testSymmetrySmartPhone() {
        Screen screen = new Screen("B001", 1);
        SmartPhone smartPhone = new SmartPhone("B001", 1, false);
        assertTrue(screen.equals(smartPhone));
        assertTrue(smartPhone.equals(screen));
    }


}
