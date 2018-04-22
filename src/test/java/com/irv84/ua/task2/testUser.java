package com.irv84.ua.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class testUser {

@Test
    public void testEqualsTrue(){
    User user1=new User("Ivan", "Ivanov");
    User user2=new User("Ivan", "Ivanov");

    assertEquals(true, user1.equals(user2));
    }

    @Test
    public void testEqualsFalse(){
        User user1=new User("Ivan", "Ivanov");
        User user2=new User("Ivan", "Ivano");

        assertEquals(false, user1.equals(user2));
    }

    @Test
    public void testHashCode(){
        User user1=new User("Ivan", "Ivanov");
        User user2=new User("Ivan", "Ivanov");

        assertEquals(user1.hashCode(), user2.hashCode());
    }




}
