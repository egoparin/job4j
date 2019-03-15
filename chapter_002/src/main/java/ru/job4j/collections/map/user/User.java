package ru.job4j.collections.map.user;

import java.time.LocalDate;

/**
 * Class user for explore map.
 *
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 05.03.2019
 */
public class User {
    private String name;
    private int children;
    private LocalDate birthday;

    public User(String name, int children, LocalDate birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + 1 + children;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User) || obj == null) {
            return false;
        }
        User user = (User) obj;
        return this.name.equals(user.name) && this.birthday.equals(user.birthday) && this.children == user.children;
    }

    /**
     * Getters and setters
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
