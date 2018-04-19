package com.irv84.ua.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class testUser {

@Test
    public void testUserWithoutHobby(){
        List<Hobby> hobbies=new ArrayList<Hobby>();
    User user=new User("Ivan", "Ivanov", hobbies);
    int countHobies=user.calculateHobbyCosts(user);

    assertEquals(0,countHobies);
}

    @Test
    public void testUserOneHobby(){
        List<Hobby> hobbies=new ArrayList<Hobby>();
        hobbies.add(new Hobby("play"));
        User user=new User("Ivan", "Ivanov", hobbies);
        int countHobies=user.calculateHobbyCosts(user);

        assertEquals(1,countHobies);
    }

    @Test
    public void testUserTwoHobby(){
        List<Hobby> hobbies=new ArrayList<Hobby>();
        hobbies.add(new Hobby("playing guitar"));
        hobbies.add(new Hobby("smoking"));
        User user=new User("Ivan", "Ivanov", hobbies);
        int countHobies=user.calculateHobbyCosts(user);

        assertEquals(2,countHobies);
    }

}
