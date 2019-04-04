package ru.job4j.collections.map.rulesoverrideequals;

import java.util.Objects;

/**
 * Test Symmetry.
 */
public class Screen {
    private String macId;
    private int speed;

    Screen(String macId, int speed) {
        this.macId = macId;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen)) return false;
        Screen screen = (Screen) o;
        return speed == screen.speed &&
                Objects.equals(macId, screen.macId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(macId, speed);
    }
}
