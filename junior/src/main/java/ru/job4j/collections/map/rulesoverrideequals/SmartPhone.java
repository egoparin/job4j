package ru.job4j.collections.map.rulesoverrideequals;

import java.util.Objects;

/**
 * Test Symmetry.
 */
class SmartPhone extends Screen {
    private boolean isHasTouchPad;

    public SmartPhone(String name, int age) {
        super(name, age);
    }

    public SmartPhone(String name, int age, boolean isHasTouchPad) {
        super(name, age);
        this.isHasTouchPad = isHasTouchPad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen)) {
            return false;
        }
        // if it is a TV object, we ignore the isHasHDMI
        if (!(o instanceof TV)){
            return o.equals(this);
        }

        SmartPhone smartPhone = (SmartPhone) o;
        return isHasTouchPad == smartPhone.isHasTouchPad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHasTouchPad);
    }
}
