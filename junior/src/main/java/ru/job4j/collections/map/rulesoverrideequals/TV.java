package ru.job4j.collections.map.rulesoverrideequals;
import java.util.Objects;

/**
 * Test Symmetry.
 */
public class TV extends Screen {
    private boolean isHasHDMI;

    public TV(String name, int speed) {
        super(name, speed);
    }

    public TV(String name, int speed, boolean isHasHDMI) {
        super(name, speed);
        this.isHasHDMI = isHasHDMI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;
        if (!super.equals(o)) return false;
        TV that = (TV) o;
        return isHasHDMI == that.isHasHDMI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHasHDMI);
    }
}
