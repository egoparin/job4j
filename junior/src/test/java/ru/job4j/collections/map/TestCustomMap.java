package ru.job4j.collections.map;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.collections.map.custommap.CustomHashMap;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author Egor Oparin (mailto:egoparin@gmail.com)
 * @version $Id$
 * @since 25.03.2019
 */
public class TestCustomMap {

    //SimpleTests
    private CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

    @Before
    public void init() {
        customHashMap.insert("first", 1);
        customHashMap.insert("second", 2);
        customHashMap.insert("third", 3);
    }

    @Test
    public void whenSimpleInsertThenFillMap() {
        int[] result = {
                customHashMap.get("first"),
                customHashMap.get("second"),
                customHashMap.get("third")};

        assertThat(result, is(new int[]{1, 2, 3}));
    }

    @Test
    public void whenSimpleDeleteThenRemoveOneFromBuckets() {
        customHashMap.delete("third");

        int[] result = {
                customHashMap.get("first"),
                customHashMap.get("second")};

        assertThat(2, is(customHashMap.getSize()));
        assertThat(result, is(new int[]{1, 2}));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void throwConcurrentModificationException() {

        for (Integer item : customHashMap) {
            customHashMap.insert("test", 6);
            System.out.println(item);
        }
    }

    /**
    /*  Collisions test methods
     */

    private CustomHashMap<TestCollisions, Integer> mapC = new CustomHashMap<>();

    private TestCollisions t1 = new TestCollisions("first",1);
    private TestCollisions t2 = new TestCollisions("second", 1);
    private TestCollisions t3 = new TestCollisions("third", 1);
    private TestCollisions anotherBucket = new TestCollisions("anotherBucket", 6);

    private class TestCollisions {
        int age;
        String name;

        TestCollisions(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            TestCollisions tc = (TestCollisions) obj;
            return name.equals(tc.name);
        }


        @Override
        public String toString() {
            return "object: " + name;
        }
    }

    /**
     * All object input in same bucket, then chosen key deleting.
     */
    @Before
    public void initCollisions(){
        mapC.insert(t1, 1);
        mapC.insert(t2, 2);
        mapC.insert(t3, 3);
        mapC.insert(anotherBucket, 4);
    }

    /**
     * after insert bucket[1] will firtst.next -> second.next -> third.next, bucket[6] = anotherBucket object.
     */
    @Test
    public void WhenGet() {
        assertThat(2, is(mapC.get(t2)));
    }

    @Test
    public void WhenDeleteMidElementListCollisionThenResolve() {

        mapC.delete(t2);

        assertThat(3, is(mapC.getSize()));
        assertThat("object: first 1\n" +
                          "object: third 3\n" +
                          "object: anotherBucket 4\n", is(mapC.toString()));
        assertNull(mapC.get(t2));
    }

    @Test
    public void WhenDeleteFirstElementListCollisionThenResolve() {

        mapC.delete(t1);

        assertThat(3, is(mapC.getSize()));
        assertThat("object: second 2\n" +
                "object: third 3\n" +
                "object: anotherBucket 4\n", is(mapC.toString()));
        assertNull(mapC.get(t1));
    }

    @Test
    public void WhenDeleteLastElementListCollisionThenResolve() {

        mapC.delete(t3);

        assertThat(3, is(mapC.getSize()));
        assertThat("object: first 1\n" +
                "object: second 2\n" +
                "object: anotherBucket 4\n", is(mapC.toString()));
        assertNull(mapC.get(t3));
    }



}
