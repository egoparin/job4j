package ru.job4j.collections.generics.store;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Egor Oparin (egoparin@gmail.com)
 * @version $Id$
 * @since 18.01.19
 */
public class StoreTest {

    /**
     * Test
     */
    @Test
    public void whenRoleStoreOperations() {
        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();

        String idRole1 = role1.getId();
        String idRole2 = role2.getId();
        String idRole3 = role3.getId();

        RoleStore roleStore = new RoleStore();
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);

        roleStore.replace(idRole3, role1);
        roleStore.delete(idRole1);

        assertThat(roleStore.toString(), is("[ " + idRole2 + " ],[ " + idRole1 + " ],"));

    }

}
