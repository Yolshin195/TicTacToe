package ru.yolshin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import  org.junit.jupiter.api.Test;

public class UserTest {
    
    @Test
    void test() {
        User user = new User("Yolshin", Label.X);
        assertEquals("Yolshin-X", user.toString());
    }
}
