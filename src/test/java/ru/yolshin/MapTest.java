package ru.yolshin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import  org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void test() {
        Map map = new Map(9);
        map.setLabel(1,1, Label.X);
        map.setLabel(2,2, Label.X);
        map.setLabel(3,3, Label.X);

        System.out.println(map);

        assertEquals(true, map.isIntersection(Label.X));
    }

    @Test
    void test2() {
        Map map = new Map(9);
        map.setLabel(3,1, Label.X);
        map.setLabel(2,2, Label.X);
        map.setLabel(1,3, Label.X);

        System.out.println(map);

        assertEquals(true, map.isIntersection(Label.X));
    }

    @Test
    void test3() {
        Map map = new Map(9);
        map.setLabel(1,1, Label.X);
        map.setLabel(2,1, Label.X);
        map.setLabel(3,1, Label.X);

        System.out.println(map);

        assertEquals(true, map.isIntersection(Label.X));
    }

    @Test
    void test4() {
        Map map = new Map(9);
        map.setLabel(3,1, Label.X);
        map.setLabel(3,2, Label.X);
        map.setLabel(3,3, Label.X);

        System.out.println(map);

        assertEquals(true, map.isIntersection(Label.X));
    }
}
